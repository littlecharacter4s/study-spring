<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>首页</title>
</head>
<body>
    <p>
        <#if Session.loginUser??>
            欢迎，${Session.loginUser.nickname}！<a href="/logout">退出</a>
        <#else>
            请<a href="/login">登录</a>！
        </#if>
    </p>
    <p>
        <a href="/user/main">个人主页</a>
    </p>
</body>
</html>