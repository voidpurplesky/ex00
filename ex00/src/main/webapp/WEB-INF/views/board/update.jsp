<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<div class="container">
update
<form action="update" method="post">
<div class="form-group">
<div>
	no : ${vo.no }
	<input type="hidden" name="no" value="${vo.no}">
	
<!-- <label for="no">no</label><input name="no" id="no" type="text" class="form-control" value=${vo.no} readonly>	 -->
</div>
	<div>
	<label for="title">title</label><input name="title" id="title" type="text" class="form-control" required value=${vo.title}>
	</div>
	<div>
	<label for="content">content</label>
	<textarea name="content" id="content" rows="10" class="form-control" required>${vo.content}</textarea>
	</div>
	<div>
	<label for="writer">writer</label><input name="writer" id="writer" type="text" class="form-control" required value=${vo.writer}>
</div>
<div>
<label for="pw">password</label><input name="pw" id="pw" type="password" class="form-control" required>
</div>
<div>
<input type="submit" class="btn btn-primary">
<button type="submit" class="btn btn-primary">submit</button>
<button type="reset" class="btn btn-primary">reset</button>
<button type="button" class="btn btn-primary">cancel</button>
</div>
</div>

</form>
</div>
</body>
</html>