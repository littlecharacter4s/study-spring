<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Hello World</title>

</head>
<body>
<h3>${content}</h3>
<p>
    <#if Session.hellox??>
        ${Session.hello}
    <#else>
        呵呵
    </#if>
</p>
</body>
</html>