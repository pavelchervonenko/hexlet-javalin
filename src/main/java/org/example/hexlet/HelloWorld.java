package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;


import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;

import java.time.LocalDateTime;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // --Middlewares--
        app.before(ctx -> {
           System.out.println("Запрос получен: " + LocalDateTime.now() + " | " + ctx.method() + " " + ctx.path());
        });

        app.after(ctx -> {
           System.out.println("Запрос обработан: " + LocalDateTime.now() + " | " + ctx.method() + " " + ctx.path());
        });

        // -- Сессия --
        app.get(NamedRoutes.buildSessionsPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        // -- Общие страницы --
        app.get(NamedRoutes.rootPath(), ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.mainPagePath(), ctx -> ctx.render("menu.jte"));

        // -- Пользователи --
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPathTpl(), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);

        // - Добавить
//        app.get(NamedRoutes.editUserPath(), UsersController::edit);
//        app.patch("/users/{id}", UsersController::update);
//        app.delete("/users/{id}", UsersController::destroy);

        app.get(NamedRoutes.userPostPathTpl(), ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var postId = ctx.pathParamAsClass("postId", Long.class).get();
            ctx.result("userId " + userId + " postId " + postId);
        });

        // -- Курсы --
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursesPath(), CoursesController::build);
        app.get(NamedRoutes.coursePathTpl(), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);

        // - Добавить
//        app.get(NamedRoutes.editCoursePath(), CoursesController::edit);
//        app.patch("/courses/{id}", CoursesController::update);
//        app.delete("/courses/{id}", CoursesController::destroy);
        app.start(7070);
    }
}