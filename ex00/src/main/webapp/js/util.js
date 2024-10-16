/**
 * {
    "page": 1,
    "perPageNum": 10,
    "startRow": 1,
    "endRow": 10,
    "perGroupPageNum": 10,
    "startPage": 1,
    "endPage": 1,
    "totalPage": 1,
    "totalRow": 5,
    "key": null,
    "word": null,
    "period": "pre",
    "notPageQuery": "perPageNum=10&key=&word=",
    "pageQuery": "page=1&perPageNum=10&key=&word="
}
 */

function replyPagination(pageObject) {

    let str = "";

    // 이전페이지
 	str += '<li class="page-item';
 	if (pageObject.startPage == 1) str += ' disabled '; // 이전페이지가 없으면 disabled
 	str += '" data-page="' + (pageObject.startPage - 1) + '"><a class="page-link" href="#">Previous</a></li>';
 	
 	for (let i = pageObject.startPage; i <= pageObject.endPage; i++) {
        str += '<li class="page-item';
        if (replyPage == i) str += ' active ';
        str += '"  data-page="' + i + '"><a class="page-link" href="#">' + i + '</a></li>';

 	}

    str += '<li class="page-item';
    if (pageObject.endPage >= pageObject.totalPage) str += ' disabled ';
    str += '" data-page="' + (pageObject.endPage + 1) + '"><a class="page-link" href="#">Next</a></li>';
	
    return str;
 }