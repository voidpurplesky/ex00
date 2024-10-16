<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<%--
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반게시판리스트</title>
<style type="text/css">
.dataRow>.card-header {
	background: #e0e0e0;
}
.dataRow:hover {
	border-color: orange;
	cursor: pointer;
}
</style>
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<script>
$(function(){
	$(".dataRow").click(function(){
		let no = $(this).data("no");
		location = "view?no=" + no + "&${pageObject.pageQuery}";
	});
	
	$("#perPageNum").change(function(){
		console.log($("#perPageNum").val());
		
		location = "list?perPageNum=" + $("#perPageNum").val();
	});
	
	$("#key").val('${(empty pageObject.key) ? "t": pageObject.key}');
	$("#perPageNum").val('${(empty pageObject.perPageNum) ? "10": pageObject.perPageNum}');
});
</script>

</head>
<body>

<%-- <decorator:main/> --%>
<%-- ${list} --%>
<div class="container">
  <h2>Card Header and Footer</h2>
  <div class="card">
    <div class="card-header">card-header
    	<a href="writeForm" class="btn btn-primary" id="writeForm">writeForm</a>
    </div>
    <div class="card-body">
    	<!-- search -->
    	<form action="list.do" id="searchForm">
    	<input type="hidden" name="page" value="1">
		<div class="row">
			<div class="col-md-8">
	  			<div class="input-group mt-3 mb-3">
					<div class="input-group-prepend">
						<select class="form-control" id="key" name="key">
							<option value="t">제목</option>
					        <option value="c">내용</option>
					        <option value="w">작성자</option>
					        <option value="tc">제목/내용</option>
					        <option value="tw">제목/작성자</option>
					        <option value="cw">내용/작성자</option>
					        <option value="tcw">모두</option>
						</select>
					</div>
		      		<input type="text" class="form-control" placeholder="검색어입력"
	      				id="word" name="word" value="${pageObject.word }">
					<div class="input-group-prepend">
						<button type="submit" class="btn btn-primary">
							<i class="fa fa-search"></i></button>
					</div>
			    </div>
			</div> <!-- end of class="col-md-8" -->
			<div class="col-md-4">
				<div class="input-group mt-3 mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Rows/Page</span>
				  </div>
				  <select id="perPageNum" name="perPageNum" class="form-control">
				   		<option>10</option>
				   		<option>15</option>
				   		<option>20</option>
				   		<option>25</option>
				  </select>
				</div>
			</div> <!-- end of class="col-md-4" -->
		</div><!-- end of class="row" -->
	</form>
    	<!-- /search -->
    <c:forEach items="${list}" var="vo">
    <a href="/board/view?no=${vo.no}">
    	<div class="card dataRow" data-no="${vo.no }">
    		<div class="card-header">
    			<span class="float-right">${vo.hit }</span>
    			${vo.no }. ${vo.title }
    		</div>
    		<div class="card-body"><pre>${vo.content }</pre></div> 
    		<div class="card-footer">
    			<span class="float-right">
    				<fmt:formatDate value="${vo.writedate }"/>
    				<fmt:formatDate value="${vo.writedate }" pattern="yyyy-MM-dd"/>
    			</span>
    			${vo.writer}
    		</div>
  		</div>
  		</a>
    </c:forEach>
    	
    
    </div> 
    <div class="card-footer">
    <div>
    	<pageNav:pageNav listURI="list" pageObject="${pageObject}"/>
    </div>
    	<a href="writeForm" class="btn btn-primary" id="writeForm">writeForm</a>
    </div>
  </div>
</div>



</body>
</html>