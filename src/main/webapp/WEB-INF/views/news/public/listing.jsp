<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <div class="col-md-8 col-lg-offset-2">
            <h3 class="text-center">Story Listing <span class="story-loader"> ( Loading... )</span></h3>
            <hr>
            <c:if test="${not empty errorMsg}">
                <h5 class="text-center error">${errorMsg}</h5>
            </c:if>
            <c:if test="${not empty successMsg}">
                <h5 class="text-center success-msg">${successMsg}</h5>
            </c:if>
            <div class="form-inline form-group advance-filter">
                <label>Advance Filter: </label>
                <select class="form-control" id="storyDate">
                    <option value="0">All The Stories</option>
                    <option value="1">Current and Future Stories</option>
                </select>
                <input type="text" class="form-control" id="storySearchTitle" placeholder="Search by title">
            </div>
            <div id="stories">
                <c:forEach var="story" items="${storyPageData.newsStoryDtos}">
                    <div class="story">
                        <h4><c:out value="${story.title}"></c:out></h4>
                        <p>
                            By <b>
                            <c:choose>
                                <c:when test="${not empty story.userDto}"> <c:out value="${story.userDto.fullName}"></c:out> </c:when>
                                <c:otherwise>Anonymous</c:otherwise>
                            </c:choose>
                            </b>

                            on <b>
                            <c:choose>
                                <c:when test="${not empty story.publishDate}">
                                    <c:out value="${story.publishDate}"></c:out>
                                </c:when>
                                <c:otherwise>Unknown</c:otherwise>
                            </c:choose>
                            </b></p>
                        <div class="panel-body">
                            ${story.contentBody}
                        </div>
                        <div class="panel-default">

                                <a target="_blank" href="${pageContext.request.contextPath}/public/api/news/stories/json/${story.id}" class="btn btn-default">JSON</a>
                                <a target="_blank" href="${pageContext.request.contextPath}/public/api/news/stories/xml/${story.id}" class="btn btn-default">XML</a>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${storyPageData.newsStoryDtos.size() == 0}">
                    <div class="story">
                        <h4 class="text-center">No Stories</h4>
                    </div>
                </c:if>
            </div>
            <div class="stories-pagination">

            </div>
        </div>

<script>
    var ROOT_URL = "/public";

    $(document).ready(function () {
        createPagination(${storyPageData.maxPageNumber}, '.stories-pagination');
    });

    maxPageNumber=${storyPageData.maxPageNumber};
    pageNumber = 1;
    var storyDate = 0;
    var searchValue = "";
    if(maxPageNumber == 0){
        pageNumber = 0;
    }

    function getAjaxPageData() {
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}' + ROOT_URL + '/news/stories/ajax/'+storyDate+'/' + pageNumber + '?searchText=' + searchValue,
            success: function( data ) {
                $('#stories').html('');
                var i=0;

                for(i=0; i<data.newsStoryDtos.length; i++){
                    var publisherName = 'Anonymous';
                    if(data.newsStoryDtos[i].userDto != null){
                        publisherName = data.newsStoryDtos[i].userDto.fullName;
                    }

                    var publishDate = 'Unknown Date';
                    if(data.newsStoryDtos[i].publishDate != null){
                        publishDate = data.newsStoryDtos[i].publishDate;
                    }

                    var story = '<div class="story">' +
                        '<h4>'+data.newsStoryDtos[i].title+'</h4>' +
                        '<p>By <b>' + publisherName + '</b> on <b>'+publishDate+'</b></p>' +
                        '<div class="panel-body">' +
                         data.newsStoryDtos[i].contentBody +
                        '</div>' +
                        '<div class="panel-default">' +
                        '<a target="_blank" href="${pageContext.request.contextPath}/public/api/news/stories/json/'+data.newsStoryDtos[i].id+'" class="btn btn-default">JSON</a>' +
                        '<a target="_blank" href="${pageContext.request.contextPath}/public/api/news/stories/xml/'+data.newsStoryDtos[i].id+'" class="btn btn-default">XML</a>';

                    $('#stories').html($('#stories').html() + story);
                }

                createPagination(data.maxPageNumber, '.stories-pagination');
                $(".story-loader").hide();
            },
            error: function( data ) {
                alert( "ERROR:  " + data );
                $(".story-loader").hide();
            }
        });
    }

    $(document).on('click', '.pagination-btn', function () {
        pageNumber = Number($(this).html());
        getAjaxPageData();
    });

    $(document).on('click', '.pg-gt', function () {
        if(pageNumber < maxPageNumber){
            pageNumber++;
            getAjaxPageData();
        }
    });

    $(document).on('click', '.pg-lt', function () {
        if(pageNumber > 0){
            pageNumber--;
            getAjaxPageData();
        }
    });

    $( "#storyDate" ).change(function() {
        var value = $(this).val();
        if(value == 0){
            storyDate = 0;
        } else {
            storyDate = getTimeTodayInMillis();
        }
        pageNumber = 1;
        getAjaxPageData();
    });

    $('#storySearchTitle').on('input', function() {
        searchValue = $(this).val();
        getAjaxPageData();
    });
</script>


