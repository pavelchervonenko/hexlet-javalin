package org.example.hexlet;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.dto.courses.CoursesPage;
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

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/main-page", ctx -> {
           ctx.render("menu.jte");
        });

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
           var name = ctx.formParam("name").trim();
           var email = ctx.formParam("email").trim().toLowerCase();
           var password = ctx.formParam("password");
           var passwordConfirmation = ctx.formParam("passwordConfirmation");

           var user = new User(name, email, password);
           UserRepository.save(user);
           ctx.redirect("/users");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var userId = ctx.pathParam("id");
            var escapedUserId = StringEscapeUtils.escapeHtml4(userId);
            ctx.html(escapedUserId);
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var postId = ctx.pathParamAsClass("postId", Long.class).get();
            ctx.result("userId " + userId + " postId " + postId);
        });

        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

        app.get("/courses", ctx -> {
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