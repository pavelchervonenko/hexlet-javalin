package org.example.hexlet;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;

import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import org.example.hexlet.model.User;
import org.example.hexlet.model.Course;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

//        var courses = List.of(
//                new Course("Python", "Frontend"),
//                new Course("Python", "Backend"),
//                new Course("Java", "Backend"),
//                new Course("PHP", "php developer"));

        app.get(NamedRoutes.rootPath(), ctx -> ctx.render("index.jte"));

        app.get(NamedRoutes.mainPagePath(), ctx -> {
           ctx.render("menu.jte");
        });

        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
           var name = ctx.formParam("name").trim();
           var email = ctx.formParam("email").trim().toLowerCase();

           try {
               var passwordConfirmation = ctx.formParam("passwordConfirmation");
               var password = ctx.formParamAsClass("password", String.class)
                       .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                       .check(value -> value.length() > 6, "Длина пароля должна быть более 6 символов")
                       .get();
               var user = new User(name, email, password);
               UserRepository.save(user);
               ctx.redirect(NamedRoutes.usersPath());
           } catch (ValidationException e) {
               var page = new BuildUserPage(name, email, e.getErrors());
               ctx.render("users/build.jte", model("page", page));
           }
        });

        app.get(NamedRoutes.usersPath(), ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get(NamedRoutes.userPathTpl(), ctx -> {
            var userId = ctx.pathParam("id");
            var escapedUserId = StringEscapeUtils.escapeHtml4(userId);
            ctx.html("userId: " + escapedUserId);
        });

        app.get(NamedRoutes.userPostPathTpl(), ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var postId = ctx.pathParamAsClass("postId", Long.class).get();
            ctx.result("userId " + userId + " postId " + postId);
        });

        app.get(NamedRoutes.buildCoursesPath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");

            try {
                var validatedName = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Название курса должно быть более 2 символов")
                        .get()
                        .trim();
                var validatedDescription = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Описание курса должно быть более 10 символов")
                        .get()
                        .trim();
                var course = new Course(validatedName, validatedDescription);
                CourseRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        app.get(NamedRoutes.coursesPath(), ctx -> {
            var term = ctx.queryParam("term");

            var courses = CourseRepository.getEntities();

            List<Course> filtered = courses;
            if (term != null && !term.isBlank()) {
                String q = term.toLowerCase();
                filtered = courses.stream()
                        .filter(c ->
                                (c.getName() != null && c.getName().toLowerCase().contains(q)) ||
                                (c.getDescription() != null && c.getDescription().toLowerCase().contains(q))
                        )
                        .toList();
            }

            String header;
            if (term == null || term.isBlank()) {
                header = "Все курсы";
            } else {
                header = "Найдено курсов: " + filtered.size();
            }

            var page = new CoursesPage(filtered, header, term == null ? "" : term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(7070);
    }
}