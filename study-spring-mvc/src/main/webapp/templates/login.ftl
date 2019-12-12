<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>Login</title>
    <!-- custom css -->
    <link rel="stylesheet" href="/static/css/custom.css">
    <!-- bootstrap core css -->
    <link rel="stylesheet" href="/static/bootstrap-3.3.7/css/bootstrap.min.css">
    <!-- jquery -->
    <script src="/static/js/jquery-2.1.1.min.js"></script>
    <!-- bootstrap core js -->
    <script src="/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="text-center">
    <form style="width: 300px;margin:50px auto;" action="/login" method="post">
        <input type="hidden" id="forwardUrl" name="forwardUrl" value="${forwardUrl}">
        <img class="mb-4" src="/static/image/lc.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <p style="color: red;">${msg}</p>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" id="rememberme" name="rememberme" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
    </form>
</body>
</html>