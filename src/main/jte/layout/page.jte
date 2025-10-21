@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Website layout</title>

        <style>
            /* Сброс базовых отступов */
            * { box-sizing: border-box; }
            html, body { margin: 0; padding: 0; }

            .topbar {
              width: 100%;
              position: sticky;
              top: 0;
              display: flex;
              align-items: center;
              justify-content: space-between;
              padding: 12px 20px;
              border-bottom: 1px solid #e5e7eb;
              background: #ffffff;
            }

            .brand {
              font-size: 1.125rem;      /* ~18px */
              font-weight: 700;
              margin: 0;
            }

            .nav {
              display: flex;
              gap: 16px;
            }

            .nav a {
              text-decoration: none;
              color: #111827;
              font-weight: 500;
            }

            .nav a:hover {
              text-decoration: underline;
            }

            .container {
              max-width: 960px;
              margin: 24px auto;
              padding: 0 16px;
            }
        </style>

    </head>
    <body>
        <header class="topbar" role="banner">
          <h1 class="brand">Макет</h1>
          <nav class="nav" role="navigation" aria-label="Main navigation">
            <a href="/main-page">Главная</a>
            <a href="/courses">Курсы</a>
            <a href="/users">Пользователи</a>
          </nav>
        </header>

        <main class="container">
            ${content}
        </main>

    </body>
</html>