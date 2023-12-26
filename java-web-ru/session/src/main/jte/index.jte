@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
    <form>
        @if(page.getName() != null)
            <h1>${page.getName().toString()}</h1>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" placeholder="Выйти" />
            </form>
        @else
            <a href="${NamedRoutes.loginPath()}">Войти</a>
        @endif
    </form>
</main>
</body>
</html>