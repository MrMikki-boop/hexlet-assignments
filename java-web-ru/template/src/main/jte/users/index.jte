<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>User List</title>
</head>
<body>

<div class="container mt-4">
    <h1>User List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <!-- Add more columns as needed -->
        </tr>
        </thead>
        <tbody>
        @for (var userPage : usersPage.getUsers()) {
        <tr>
            <td>@userPage.getUser().getId()</td>
            <td>@userPage.getUser().getName()</td>
            <td>@userPage.getUser().getEmail()</td>
            <!-- Add more cells as needed -->
        </tr>
        }
        </tbody>
    </table>
</div>

</body>
</html>
