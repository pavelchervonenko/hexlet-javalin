@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes
@param CoursePage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>Курс: ${page.getCourse().getName()}</h1>

        <p>
            <a href="${NamedRoutes.mainPagePath()}">Вернуться на главную</a>
        </p>

        <ul>
            <li>
                <p>Название - ${page.getCourse().getName()}</p>
            </li>
            <li>
                <p>Описание:</p>
                <text>${page.getCourse().getDescription()}</text>
            </li>
        </ul>

    </body>
</html>