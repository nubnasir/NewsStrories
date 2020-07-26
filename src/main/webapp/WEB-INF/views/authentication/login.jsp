<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/12/18
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


        <div class="col-lg-6 col-lg-offset-3">

            <h2>Log in</h2>
            <c:if test="${not empty successMsg}">
                <span class="success-msg">${successMsg}</span>
            </c:if>
            <form:form action="/do-login" method="post" modelAttribute="loginDto">
                <div class="form-group">
                    <label for="j_username">User Name (Id):</label>
                    <form:input cssClass="form-control" path="j_username" autocomplete="off" autofocus="true"></form:input>
                    <form:errors path="j_username"></form:errors>
                </div>
                <div class="form-group">
                    <label for="j_password">Password:</label>
                    <form:password cssClass="form-control" path="j_password" ></form:password>
                    <form:errors path="j_password"></form:errors>
                </div>
                <div>
                    <c:if test="${not empty param.error}">
                        <span class="error"><c:out value='${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}'></c:out></span>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
                <a href="/" class="btn btn-default">Go Home</a>
            </form:form>
        </div>

<script>

    $(document).ready(function () {
        $("#loginDto").validate({
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: "Please enter a user name"
                },
                password: {
                    required: "Password is required"
                }
            }
        });
    });
</script>