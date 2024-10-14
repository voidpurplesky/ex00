<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<script>
console.log("1: <head><script> s");
$(function(){

	console.log("last: $(function(){}); s");
	/* $("#test").click(function(){
		$('#myModal').modal('show');
	}); */

	

	
	});
	
$("#updateBtn").click(function(){
	location = "update?no=${vo.no}";
});

$("#deleteBtn").click(function(){
	$("#pw").val("");
});

$.get("/boardreply/list?page=1&no=${vo.no }", function(data, status){
	console.log(typeof data); // string / object
	console.log(data);
	console.log(data.map);
	//console.log(data.length); // 0 / un
	
	console.log(data.list); // undefined
	console.log(status); // success
	console.log("Data: " + data + "\nStatus: " + status);
	
});
/*

data

#document (http://localhost/board/view?no=61)
<Map>
	<list>
		<rno>2</rno><no>61</no><content>질문있습니다.2</content>
		<id>id1</id><writedate>1728872927000</writedate></list>
	<list>
		<rno>1</rno><no>61</no><content>질문있습니다.</content>
		<id>id1</id><writedate>1728866858000</writedate>
	</list>
	<pageObject><page>1</page><perPageNum>10</perPageNum><startRow>1</startRow><endRow>10</endRow><perGroupPageNum>10</perGroupPageNum><startPage>1</startPage><endPage>1</endPage><totalPage>1</totalPage><totalRow>2</totalRow><key/><word/><period>pre</period><notPageQuery>perPageNum=10&amp;key=&amp;word=</notPageQuery><pageQuery>page=1&amp;perPageNum=10&amp;key=&amp;word=</pageQuery></pageObject>
</Map>
 */

	 
	 
console.log("2: <head><script> e");
</script>
<!-- 3: reply.js -->

<script>
let no = "${vo.no}"; // 전역변수

</script>
<script src="/js/reply.js"></script>
<script src="/js/replyProcess.js"></script>
<script src="/js/dateTime.js"></script>
<script>

//replyService.list(1,61);
replyService.list(1);
</script>
</head>
<body>
${vo}

<div class="container">
  <h2>view</h2>
  <div class="card">
    <div class="card-header">
    	
   		<a href="list" class="btn btn-primary">list</a>
   
   		<a href="update?no=${vo.no }" class="btn btn-primary">update</a> 
 
   		<a href="delete?no=${vo.no }" class="btn btn-primary">delete</a>
   		<button class="btn btn-danger" id="deleteBtn">delete</button>
    <button class="btn btn-primary" id="updateBtn">update</button>
    <button id="test" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button>
    </div>
    <div class="card-body">${vo.content }
    
    	<div class="card dataRow" data-no="${vo.no }">
    		<div class="card-header">
    			<span class="float-right">${vo.hit }</span>
    			${vo.no }. ${vo.title }
    		</div>
    		<div class="card-body"><pre>${vo.content }</pre></div> 
    		<div class="card-footer">
    			<span class="float-right"><fmt:formatDate value="${vo.writedate }" pattern="yyyy-MM-dd"/></span>
    			${vo.writer}
    		</div>
  		</div>
    
    </div> 
    <div class="card-footer">${vo.writer } ${vo.hit }
    	<button class="btn btn-primary" id="updateBtn">update</button>
    </div>
  </div>
  
  <jsp:include page="boardreply.jsp"/>
</div><!-- container -->
<div id="myModal" class="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<form action="delete" method="post">
	<input type="hidden" name="no" value="${vo.no }">
	<div class="modal-body">
		<div class="form-group">
			<input class="form-control" type="password" name="pw" id="pw">
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn btn-danger">delete</button>
		<button class="btn btn-secondary" data-dismiss="modal">close</button>
	</div>
</form>
</body>
</html>