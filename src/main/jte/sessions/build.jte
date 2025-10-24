@import org.example.hexlet.NamedRoutes

<!doctype html>
<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>

    <form action="${NamedRoutes.sessionsPath()}" method="post">
      <input type="text" placeholder="Nickname" name="nickname" />
      <input type="password" placeholder="Password" name="password" />
      <input type="submit" />
    </form>

    </body>
</html>