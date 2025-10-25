package org.example.hexlet.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;

import org.example.hexlet.NamedRoutes;

import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import org.example.hexlet.model.Course;

import org.example.hexlet.repository.CourseRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class CoursesController {
    public static void index(Context ctx) {
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
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
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
    }

//    public static void edit(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//        var course = CourseRepository.find(id)
//                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
//        var page = new CoursePage(course);
//        ctx.render("courses/edit.jte", model("page", page));
//    }
//
//    // Поправить
//    public static void update(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//
//        var name = ctx.formParam("name");
//        var email = ctx.formParam("email");
//        var password = ctx.formParam("password");
//
//        var user = UserRepository.find(id)
//                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        UserRepository.save(user);
//        ctx.redirect(NamedRoutes.usersPath());
//    }
//
//    public static void destroy(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//        CourseRepository.delete(id);
//        ctx.redirect(NamedRoutes.coursesPath());
//    }
}
