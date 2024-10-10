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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$(".dataRow").click(function(){
		let no = $(this).data("no");
		location = "view?no=" + no;
	});
});
</script>
</head>
<body>
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<%-- <decorator:main/> --%>
${list}
<a href="writeForm">writeForm</a>
<div class="container">
  <h2>Card Header and Footer</h2>
  <div class="card">
    <div class="card-header">card-header</div>
    <div class="card-body">
    <c:forEach items="${ list}" var="vo">
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