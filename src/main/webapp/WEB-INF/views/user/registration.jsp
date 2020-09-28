<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <div class="col-lg-6 col-lg-offset-3">

            <h2>Registration</h2>
            <form:form commandName="registrationDto" method="post">
                <div class="form-group">
                    <label for="userName">User Name (Id):</label>
                    <form:input cssClass="form-control" path="userName" autocomplete="off"></form:input>
                    <form:errors path="userName"></form:errors>
                </div>
                <div class="form-group">
                    <label for="fullName">Full Name:</label>
                    <form:input cssClass="form-control" path="fullName" autocomplete="off"></form:input>
                    <form:errors path="fullName"></form:errors>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <form:password cssClass="form-control" path="password"></form:password>
                    <form:errors path="password"></form:errors>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password:</label>
                    <form:password cssClass="form-control" path="confirmPassword"></form:password>
                    <form:errors path="confirmPassword"></form:errors>
                </div>

                <button type="submit" class="btn btn-primary">Register</button>
                <a href="/" class="btn btn-default">Go Home</a>
                <c:if test="${not empty errorMsg}">
                    <span class="success-msg">${errorMsg}</span>
                </c:if>
            </form:form>
        </div>

<script>

    $(document).ready(function () {
        $("#registrationDto").validate({
            rules: {
                userName: {
                    required: true,
                    minlength: 4,
                    maxlength: 50,
                    remote: "/registration/unique/user/name"
                },
                fullName: {
                    required: true,
                    minlength: 4,
                    maxlength: 50
                },
                password: {
                    required: true
                },
                confirmPassword: {
                    required: true
                }
            },
            messages: {
                userName: {
                    required: "Please enter a user name",
                    minlength: "User Name must consist of at least 4 characters",
                    maxlength: "User Name must consist maximum of 50 characters",
                    remote: "User name is already exists"
                },
                fullName: {
                    required: "Full Name is required",
                    minlength: "Full Name must consist of at least 4 characters",
                    maxlength: "Full Name must consist maximum of 50 characters"
                },
                password: {
                    required: "Password is required"
                },
                confirmPassword: {
                    required: "Confirm Password is required"
                }
            }
        });
    });
</script>