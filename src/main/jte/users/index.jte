@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.NamedRoutes
@param UsersPage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>Пользователи</h1>

        <p>
            <a href="${NamedRoutes.buildUserPath()}">Создать пользователя</a>
        </p>

        <p>
            <a href="${NamedRoutes.mainPagePath()}">На главную</a>
        </p>

        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <ul>
            @for(var user : page.getUsers())
                <li>
                    <a href="${NamedRoutes.userPath(user.getId())}">${user.getName()}</a>
                    - ${user.getEmail()}
                </li>
            @endfor
            </ul>
        @endif
    </body>
</html>