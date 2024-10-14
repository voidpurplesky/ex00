/**
 * src/main/webapp/js/reply.js
 
 */
console.log("3: reply.js s");

let replyService = {

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
console.log("3: write.js s");
},
"update": function(reply, callback, error) {
console.log("3: update.js s");
},
"delete": function(reply, callback, error) {
console.log("3: delete.js s");
}
};