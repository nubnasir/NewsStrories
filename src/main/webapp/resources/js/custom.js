
function getTimeTodayInMillis() {
    var today = new Date();
    return today.getTime()
}

var maxPageNumber = 0;
var pageNumber = 0;

function createPagination(maxPageNum, elem) {
    $(elem).html('<button class="btn btn-default pg-lt">&lt;</button>');

    var i=0;
    for(i=1;i<=maxPageNum;i++){
        var activeClass = '';
        if(pageNumber == i) {
            activeClass = 'stories-pagination-active';
        }
        var paginationPortion = '<button class="pagination-btn btn btn-default ' + activeClass + '">'+ i +'</button>';
        $(elem).html($(elem).html() + paginationPortion );
    }
    $(elem).html($(elem).html() + '<button class="btn btn-default pg-gt">&gt;</button>');
    maxPageNumber = maxPageNum;
}