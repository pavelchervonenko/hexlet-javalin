package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.apache.commons.text.StringEscapeUtils;


import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        var courses = List.of(
                new Course("Python", "Frontend"),
                new Course("Python", "Backend"),
                new Course("Java", "Backend"),
                new Course("PHP", "php developer"));

        app.get("/main-page", ctx -> {
           ctx.render("menu.jte");
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");

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

        app.get("/", ctx -> ctx.render("index.jte"));

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

        app.start(7070);
    }
}