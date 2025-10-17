@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>Пользователи</h1>

        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <ul>
            @for(var user : page.getUsers())
                <li>${user.getName()} - ${user.getEmail()}</li>
            @endfor
            </ul>
        @endif
    </body>
</html>