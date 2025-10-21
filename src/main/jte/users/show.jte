@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes
@param UserPage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>Ваш профиль</h1>

        <p>
            <a href="${NamedRoutes.mainPagePath()}">Вернуться на главную</a>
        </p>

        <ul>
            <li>
                <p>Имя - ${page.getUser().getName()}</p>
            </li>
            <li>
                <p>Email - ${page.getUser().getEmail()}</p>
            </li>
        </ul>

    </body>
</html>