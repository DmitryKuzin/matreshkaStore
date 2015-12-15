<!DOCTYPE html>
<html>
<head>
    <title>main</title>
    <meta charset = "UTF-8">
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/cart_style.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/sign_in_style.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/item_style.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/header_style.css"  media="screen,projection"/>
</head>
<body>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript">
    $('#myModal').modal(options);
</script>

<#include "header.ftl" />
<#include "cart.ftl" />
<@m_body />
<#include "footer.ftl" />
</body>
</html>