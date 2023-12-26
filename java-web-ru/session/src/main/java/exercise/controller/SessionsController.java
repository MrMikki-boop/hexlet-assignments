package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("build.jte");
        ctx.redirect("/");
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var user = UsersRepository.findByName(name);
        ctx.sessionAttribute("currentUser", name);
        if (user != null && user.getPassword().equals(encrypt(password)) && user.getName().equals(name)) {
            ctx.redirect("/");
        } else {
            var page = new LoginPage(ctx.sessionAttribute("currentUser"), "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}
