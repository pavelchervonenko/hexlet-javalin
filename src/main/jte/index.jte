@import org.example.hexlet.dto.MainPage
@param MainPage page

<!doctype html>
<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <main>
                  <h1>Привет, Хекслет!</h1>
                  @if(page.getCurrentUser() != null)
                    Добро пожаловать, ${page.getCurrentUser()}.
                    Чтобы разлогиниться, удалите куку JSESSIONID из браузера
                  @endif
            </main>
        </div>
    </body>
</html>