<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/index.css" rel="stylesheet">
<title>投诉页</title>
</head>
<body>
	<h1>投诉内容</h1>
	<form>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio1" value="A">
		  <label class="form-check-label" for="inlineRadio1">涉及黄色</label>
		
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio2" value="B">
		  <label class="form-check-label" for="inlineRadio2">涉及暴力</label>
		
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio3" value="C">
		  <label class="form-check-label" for="inlineRadio3">涉及宗教政策</label>
		
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio4" value="D">
		  <label class="form-check-label" for="inlineRadio3">涉及国家安全</label>
		  
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio5" value="F">
		  <label class="form-check-label" for="inlineRadio3">抄袭内容</label>
		  
		  <input class="form-check-input" type="radio" name="complaintype" id="inlineRadio6" value="g">
		  <label class="form-check-label" for="inlineRadio3">其它</label>
		</div><br>
		<input type="hidden" value="${articleId }" name="articleId">
		证据url地址<input class="form-group mx-sm-3 mb-2" type="text" name="urlip" id="urlip"><br>
		<button type="button" class="btn btn-primary" onclick="tousu()">投诉</button>
	</form>
	<div class="alert alert-danger" role="alert" style="display: none"></div>
	
	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function tousu(){
			var params=$("form").serialize();
			alert(params);
			$.post(
				"/tousu/add",
				params,
				function(res){
					if(res.result){
						alert("投诉成功");
						window.location.href="/";
					}else{
						$(".alert").html(res.message);
						$(".alert").show();
					}
				}
			) 
		}
	</script>
</body>
</html>