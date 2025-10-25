@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.NamedRoutes
@param UsersPage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
        <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet">
    </head>
    <body>
        @if(page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                ${page.getFlash()}
            </div>
        @endif

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