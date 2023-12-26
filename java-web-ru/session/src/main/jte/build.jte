@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

<form action="${NamedRoutes.buildSessionPath()}" method="post">
    @if(page != null)
        <h2>${page.getError()}</h2>
    @endif
    <input type="text" placeholder="Name" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>