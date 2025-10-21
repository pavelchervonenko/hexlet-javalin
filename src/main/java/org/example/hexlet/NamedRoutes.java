package org.example.hexlet;

public class NamedRoutes {

    // Общие страницы
    public static String rootPath() {
        return "/";
    }

    public static String mainPagePath() {
        return "/main-page";
    }

    // Пользователи
    public static String usersPath() {
        return "/users";
    }

    public static String userPathTpl() {
        return "/users/{id}";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String editUserPath() {
        return "/users/{id}/edit";
    }

    public static String userPostPathTpl() {
        return "/users/{id}/post/{postId}";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String userPostPath(String userId, String postId) {
        return "/users/" + userId + "/post/" + postId;
    }

    // Курсы
    public static String coursesPath() {
        return "/courses";
    }

    public static String coursePathTpl() {
        return "/courses/{id}";
    }

    public static String buildCoursesPath() {
        return "/courses/build";
    }

    public static String editCoursePath() {
        return "/courses/{id}/edit";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }
}
