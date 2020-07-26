<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/10/18
  Time: 3:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <script>
        $( function() {
            $( "#publishDate" ).datepicker({
                minDate: '0'
            });
        } );
    </script>

        <div class="col-lg-6 col-lg-offset-3">

            <h2>News and Stories (${operationType})</h2>
            <form:form commandName="newsStory" method="post">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <form:input cssClass="form-control" path="title" autocomplete="off"></form:input>
                    <form:errors path="title"></form:errors>
                </div>
                <div class="form-group">
                    <label for="contentBody">Content Body:</label>
                    <form:textarea cssClass="form-control" path="contentBody"></form:textarea>
                    <form:errors path="contentBody"></form:errors>
                </div>
                <div class="form-group">
                    <label for="publishDate">Publish Date:</label>
                    <form:input cssClass="form-control" path="publishDate" readonly="true"></form:input>
                    <form:errors path="publishDate"></form:errors>
                </div>
                <form:hidden path="id"></form:hidden>

                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="/" class="btn btn-default">Go Home</a>
                <c:if test="${not empty successMsg}">
                    <span class="success-msg">${successMsg}</span>
                </c:if>
            </form:form>
        </div>

<script>

    $(document).ready(function () {
        $("#newsStory").validate({
            rules: {
                title: {
                    required: true,
                    minlength: 2,
                    maxlength: 200
                },
                contentBody: {
                    required: true
                },
                publishDate: {
                    required: true
                }
            },
            messages: {
                title: {
                    required: "Please enter a title",
                    minlength: "Title must consist of at least 2 characters",
                    maxlength: "Title must consist of maximum 200 characters"
                },
                contentBody: {
                    required: "Content body is required"
                },
                publishDate: {
                    required: "Publish Date is required"
                }
            }
        });
    });
</script>