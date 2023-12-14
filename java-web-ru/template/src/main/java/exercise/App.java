package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/", ctx -> {
            UsersPage usersPage = new UsersPage(USERS.stream()
                    .map(UserPage::new)
                    .collect(Collectors.toList()));
            ctx.render("users/index.jte", Map.of("usersPage", usersPage));
        });

        app.get("/users", ctx -> {
            UsersPage usersPage = new UsersPage(USERS.stream()
                    .map(UserPage::new)
                    .collect(Collectors.toList()));
            ctx.render("users/index.jte", Map.of("usersPage", usersPage));
        });

        app.get("/users/:id", ctx -> {
            int userId = ctx.pathParam("id", Integer.class).get();
            User user = USERS.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .orElseThrow(NotFoundResponse::new);

            UserPage userPage = new UserPage(user);
            ctx.render("users/show.jte", Map.of("userPage", userPage));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
