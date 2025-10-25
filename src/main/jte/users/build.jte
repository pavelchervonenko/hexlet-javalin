@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.NamedRoutes
@param BuildUserPage page

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

         @if(page.getErrors() != null)
            <div class="alert alert-danger" role="alert">
                <ul class="mb-0">
                   @for(var validator : page.getErrors().values())
                     @for(var error : validator)
                       <li>${error.getMessage()}</li>
                     @endfor
                   @endfor
                </ul>
            </div>
         @endif

        <form action="${NamedRoutes.usersPath()}" method="post">
          <div>
            <label>
              Имя
              <input type="text" name="name" value="${page.getName()}" />
            </label>
          </div>
          <div>
            <label>
              Email
              <input type="email" required name="email" value="${page.getEmail()}" />
            </label>
          </div>
          <div>
            <label>
              Пароль
              <input type="password" required name="password" />
            </label>
          </div>
          <div>
            <label>
              Подтверждение пароля
              <input type="password" required name="passwordConfirmation" />
            </label>
          </div>
          <input type="submit" value="Зарегистрировать" />
        </form>

    </body>
</html>
