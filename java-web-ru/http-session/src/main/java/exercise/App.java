package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            int page = getPageParam(ctx);
            int perPage = getPerPageParam(ctx);

            List<Map<String, String>> paginatedUsers = paginateUsers(page, perPage);
            ctx.json(paginatedUsers);
        });

        return app;
    }

    private static int getPageParam(io.javalin.http.Context ctx) {
        String pageParam = ctx.queryParam("page");
        return pageParam != null ? Integer.parseInt(pageParam) : 1;
    }

    private static int getPerPageParam(io.javalin.http.Context ctx) {
        String perPageParam = ctx.queryParam("per");
        return perPageParam != null ? Integer.parseInt(perPageParam) : 5;
    }

    private static List<Map<String, String>> paginateUsers(int page, int perPage) {
        int startIndex = (page - 1) * perPage;
        int endIndex = Math.min(startIndex + perPage, USERS.size());
        return USERS.subList(startIndex, endIndex);
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
