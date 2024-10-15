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
				
				str += '<li class="left clearfix" data-rno="' + list[i].rno + '">'
						+ '<div>'
						
						+	'<div class="header">'
						+		'<strong class="primary-font">'+ list[i].name +'(' + list[i].id + ')</strong>'
						+		'<small class="pull-right text-muted">' + date + '</small>'
						+	'</div>'
						+	'<p><pre class="replyContent">' + list[i].content + '</pre></p>';
						
				
				if (id == list[i].id) {
					str += '<div>'
					+	'<button class="replyUpdateBtn btn btn-success btn-sm">update</button>'
					+	'<button class="replyDeleteBtn btn btn-danger btn-sm">delete</button>'
					+'</div>'
				}
				
				str += '</div>'
				+	'</li>';
			}
			
			$(".chat").html(str);
			
		}
	);
}

showList(1);

// 태그들이 모두 올라온후 실행되는 나중에 
$(function(){

	// 댓등록
	$("#newReplyBtn").click(function(){
		$("#replyUpdateBtn").hide();
		$("#replyContent").val("");
		$("#replyModal .modal-title").val("댓등록");
	});
	
	// 댓수정 자바스크립트로 작성한 코드에서의 선택불가-원래존재하는 코드중에 선택하여 사용
	// 이벤트위침 첫번째 이벤트를 두번째 객체가 처리. 3번째 함수를 사용
	$(".chat").on("click", ".replyUpdateBtn", function(){
		console.log("댓수정버튼클릭");
		
		$("#replyWriteBtn").hide();
		$("#replyModal .modal-title").val("댓수정");
		
		// 위로 올라가서 처음만나는 li 태그 위치
		let li = $(this).closest("li");
		console.log(li);
		console.log(li.find(".replyContent"));
		console.log(li.find(".replyContent").html());
		
		$("#replyRno").val(li.data("rno"));
		$("#replyContent").html(li.find(".replyContent").html());
		
		$("#replyModal").modal("show");
		console.log($("#replyRno").val());
		
		console.log($(".replyContent").val());
	});
	
	
	// 모달댓수정버튼
	$("#replyUpdateBtn").click(function(){
		// rno
		console.log("modal replyUpdateBtn click");
		console.log($("#replyRno").val());
		console.log($("#replyContent").val());
		
		let reply = {rno:$("#replyRno").val(), content:$("#replyContent").val()}; //no 전역변수
		//alert(JSON.stringify(reply));
		replyService.update(reply, function(){
			$("#replyModal").hide(); // close modal
			//$("#msgModal .modal-body").text(result);
			// $("#msgModal").modal("show");
			showList(1);
			//showList(replyPage);
		});
	});
	
	$("#replyWriteBtn").click(function(){
		let reply = {no:no, content:$("#replyContent").val()}; //no 전역변수
		//alert(JSON.stringify(reply));
		replyService.write(reply, function(){
			$("#replyModal").hide(); // close modal
			//$("#msgModal .modal-body").text(result);
			// $("#msgModal").model("show");
			showList(1);
		});
		
	});
	
	// 댓삭버튼클릭
	$(".chat").on("click", ".replyDeleteBtn", function(){
		
		if (!confirm("delete?")) return;
		
		let rno = $(this).closest("li").data("rno");
		console.log(rno);
		
		if (rno == null) return; 
		
		replyService.delete(rno, function(){
			showList(1);
		});
		
	});
	
}); // $(function(){