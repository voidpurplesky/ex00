<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${vo}
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<div class="container">
  <h2>Card Header and Footer</h2>
  <div class="card">
    <div class="card-header">${vo.title }</div>
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
</div>
</body>
</html>