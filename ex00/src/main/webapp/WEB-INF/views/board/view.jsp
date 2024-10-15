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
let id = "id1";
let replyPage = 1;
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
   		<a href="/board/list" class="btn btn-primary">list</a>
   		<a href="/board/update?no=${vo.no }" class="btn btn-success">update</a> 
   		<button class="btn btn-danger" id="deleteBtn" data-toggle="modal" data-target="#deleteModal">delete</button>    
    </div>
    <div class="card-body">
    
    	<div class="card dataRow" data-no="${vo.no }">
    		<div class="card-header">
    			<span class="float-right">${vo.hit }</span>
    			번호: ${vo.no } 제목: ${vo.title }
    		</div>
    		<div class="card-body"><pre>${vo.content }</pre></div> 
    		<div class="card-footer">
    			<span class="float-right"><fmt:formatDate value="${vo.writedate }" pattern="yyyy-MM-dd"/></span>
    			작성자: ${vo.writer}
    		</div>
  		</div>
    
    </div> 
    <div class="card-footer">
    	<a href="list" class="btn btn-primary">list</a>
   		<a href="update?no=${vo.no }" class="btn btn-success">update</a> 
   		<button class="btn btn-danger" id="deleteBtn" data-toggle="modal" data-target="#deleteModal">delete</button>
    </div>
  </div>
  
  <jsp:include page="boardreply.jsp"/>
</div><!-- container -->

<!-- The Modal -->
<div class="modal" id="deleteModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">비번입력</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
        	
        	<!-- Modal body -->
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
		</div>
	</div>
</div>

</body>
</html>