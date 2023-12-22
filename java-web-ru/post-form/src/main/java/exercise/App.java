package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Collections;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.post("/users", ctx -> {
            // Получение данных из формы
            String firstName = ctx.formParam("firstName");
            String lastName = ctx.formParam("lastName");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");

            // Нормализация данных
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            email = email.toLowerCase().trim();

            // Шифрование пароля
            String encryptedPassword = Security.encrypt(password);

            // Создание нового пользователя
            User newUser = new User(firstName, lastName, email, encryptedPassword);

            // Сохранение пользователя в репозитории
            UserRepository.save(newUser);

            // Перенаправление на страницу с пользователями
            ctx.redirect("/users");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
