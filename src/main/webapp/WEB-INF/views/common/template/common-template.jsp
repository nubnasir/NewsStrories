<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom-style.css">
    <link href="${pageContext.request.contextPath}/resources/lib/css/font-awesome.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/resources/lib/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

    <title><tiles:getAsString name="title" /></title>
</head>

<body>

<div class="container">
    <div class="row">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>