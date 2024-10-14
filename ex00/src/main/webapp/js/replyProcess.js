/**
 * replyService 객체를 이용한 댓글처리코드
 */
function showList(page) {

	replyService.list(page
	, function(data) { // 성공함수
			console.log("replyProcess Success");
			let list = data.list;
			
			// ul
			let str = "";
			
			if (list == null || list.length == 0) {
				$(".chat").html("<li>no comment</li>");
			} 
			
			for(let i = 0; i < list.length; i++) {
				let date = toDateTime(list[i].writedate);
				
				str += '<li class="left clearfix" data-rno=" + list[i].rno + ">'
						+ '<div>'
						
						+	'<div class="header">'
						+		'<strong class="primary-font">'+ list[i].name +'(' + list[i].id + ')</strong>'
						+		'<small class="pull-right text-muted">' + date + '</small>'
						+	'</div>'
						+	'<p><pre>' + list[i].content + '</pre></p>'
					+	'</div>'
				+	'</li>';
			}
			
			$(".chat").html(str);
			
		}
	);
}

showList(1);