/**
 * src/main/webapp/js/reply.js
 
 */
console.log("3: reply.js s");

let replyService = 
{
	"list": function(page, callback, error) {
	console.log("3: list.js s");
	console.log(page);
	console.log(no);
	
	if (!page ) page = 1;
	$.getJSON("/boardreply/list?page=" + page + "&no=" + no
		, function(data) { // data: 서버에서 넘겨주는 json 데이터
		console.log(data);
		console.log(JSON.stringify(data));
		if (callback) callback(data); //태그형태가 달라졌을때 사용
		}
	).fail(function(xhr, status, err) {
		console.log("fail");
		console.log(xhr);
		console.log(status);
		console.log(err);
		if (error) error();
		else alert("댓글데이터가져오기오류");
	}); 
},
"write": function(reply, callback, error) {
	console.log("write");
	
	$.ajax({
		type: "post", // 데이터전송방식
		url: "/boardreply/write",
		data: JSON.stringify(reply),
		contentType: "application/json; charset:utf-8", // 전송되는 데이터타입과 인코딩
		// 성공햇을때
		success: function(result, status, xhr) {
			if (callback) callback(result);
			else alert(result);
		},
		error: function(xhr, status, err){
			console.log("xhr:"+xhr);
			console.log(status);console.log(err);
			if (error) error(err);
			else alert('댓글등록실패');
		}
	});
},
"update": function(reply, callback, error) {
	console.log("update");
	
	$.ajax({
		type: "post", 
		url: "/boardreply/update",
		data: JSON.stringify(reply),
		contentType: "application/json; charset:utf-8",
		success: function(result, status, xhr) {
			if (callback) callback(result);
			else alert(result);
		},
		error: function(xhr, status, err){
			console.log("xhr:"+xhr);
			console.log(status);console.log(err);
			if (error) error(err);
			else alert('댓글수정실패');
		}
	});
},
	"delete": function(rno, callback, error) 
	{
		$.ajax({
			type: "get", 
			url: "/boardreply/delete?rno=" + rno,
			success: function(result, status, xhr) {
				if (callback) callback(result);
				else alert(result);
			},
			error: function(xhr, status, err) {
				console.log("xhr:"+xhr);
				console.log(status);console.log(err);
				if (error) error(err);
				else alert('댓삭실패');
			} 
		});
	}
	
};

