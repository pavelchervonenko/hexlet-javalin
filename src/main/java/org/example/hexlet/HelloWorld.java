package org.example.hexlet;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;

import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import org.example.hexlet.controller.UsersController;

import org.example.hexlet.model.User;
import org.example.hexlet.model.Course;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // -- Общие страницы --
        app.get(NamedRoutes.rootPath(), ctx -> ctx.render("index.jte"));
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