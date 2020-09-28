<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <title>404</title>
</head>

<body>

<div class="container">
    <div class="row">
        <jsp:include page="../header/header.jsp"></jsp:include>
        <div class="col-md-8 col-lg-offset-2 text-center">
            <h2 class="text-center"><i>404</i></h2>
            <p class="text-center">The page your asking for is not available.</p>
            <hr>
            <div class="text-center">
                <a href="${pageContext.request.contextPath}/public/news/stories" class="btn btn-default"><i class="fa fa-bars"></i> Go Home</a>
            </div>
            <hr>
        </div>
        <jsp:include page="../footer/footer.jsp"></jsp:include>
    </div>
</div>
</body>
</html>