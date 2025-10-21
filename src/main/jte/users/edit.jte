@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes
@param BuildUserPage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>Редактирование профиля</h1>

        <p>
            <a href="${NamedRoutes.buildUserPath()}">Создать пользователя</a>
        </p>
        <p>
            <a href="${NamedRoutes.mainPagePath()}">На главную</a>
        </p>

        <form action="${NamedRoutes.usersPath(page.getUser().getId()}" method="post">
          <div>
            <label>
              Имя
              <input type="text" name="name" value="${page.getUser.getName()}" />
            </label>
          </div>
          <div>
            <label>
              Email
              <input type="email" required name="email" value="${page.getUser().getEmail()}" />
            </label>
          </div>
          <div>
            <label>
              Пароль
              <input type="password" required name="password" value="${page.getUser().getPassword()}" />
            </label>
          </div>
          <input type="submit" value="Сохранить изменения" />
        </form>

    </body>
</html>
