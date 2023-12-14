<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Show User</title>
</head>
<body>

<div class="container mt-4">
    <h1>User Details</h1>
    <table class="table">
        <tr>
            <th>ID</th>
            <td>@userPage.getUser().getId()</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>@userPage.getUser().getName()</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>@userPage.getUser().getEmail()</td>
        </tr>
        <!-- Add more rows for additional user details -->
    </table>
</div>

</body>
</html>
