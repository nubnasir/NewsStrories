<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<hr>
<div class="text-center">
    <a href="${pageContext.request.contextPath}/" class="btn btn-default"><i class="fa fa-home"></i> Home</a>
    <a href="${pageContext.request.contextPath}/public/news/stories" class="btn btn-default"><i class="fa fa-bars"></i> Go to Public Story Listing</a>
    <sec:authorize access="isAnonymous()">
        <a href="${pageContext.request.contextPath}/login" class="btn btn-default"><i class="fa fa-sign-in"></i> Login</a>
        <a href="${pageContext.request.contextPath}/registration" class="btn btn-default"><i class="fa fa-user-plus"></i> Register</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="${pageContext.request.contextPath}/news/stories" class="btn btn-default"><i class="fa fa-th-list"></i> My Story Listing</a>
        <a href="${pageContext.request.contextPath}/news/stories/create" class="btn btn-default">Add News and Stories <i class="fa fa-plus-circle"></i></a>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-default"><i class="fa fa-sign-out"></i> Logout</a>
    </sec:authorize>
</div>
<hr>