package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // Описываем, что загрузится по адресу /

//        app.get("/courses/{id}", ctx -> {
//            var id = ctx.pathParam("id");
//            var courses = ;
//            var page = new CoursesPage(courses, header);
//            ctx.render("/courses/show.jte", model("page", page));
//        });

        app.get("/courses", ctx -> {
            var courses = List.of(new Course("lyalya", "topolya"));
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users/{id}/post/{postId}", ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var postId = ctx.pathParamAsClass("postId", Long.class).get();
            ctx.result("userId " + userId + " postId " + postId);
        });

        app.start(7070); // Стартуем веб-сервер
    }
}