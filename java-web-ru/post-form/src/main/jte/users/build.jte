<!-- src/main/jte/users/build.jte -->

@import gg.jte.Content
@param Content content
@param Content footer = null

@template.layout.page(
content = @`
    <h1>Создание нового пользователя</h1>
    <form action="/users" method="post">
        <label for="firstName">Имя:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Фамилия:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Создать">
    </form>
`,
footer = null
)
