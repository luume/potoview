<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title></title>
<script src="./resources/assets/ckeditor/ckeditor.js"></script>

<script type="text/javascript">


$(function(){
	$("#test1").click(function(){
		//var textSize = $("#editor1").val();
		
		$("#uploadForm").submit(function(){
			var textSize = CKEDITOR.instances.editor1.getData();
			if(textSize <= 0){
				alert("글을 적어주세요.");
				return false;
			}
			
		})
		
	})
	
})

</script>

</head>
<body>
	<p></p>	
	<div style="width: 1200px; margin: auto;">
		<div class="profile-name-card" style="overflow: auto;"></div>
		<form id="uploadForm" class="form-signin" method="post" action="${pageContext.request.contextPath }/uploadOk" enctype="multipart/form-data">
		<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>

			<label for="title">제목</label>
			<input type="text" name="title"  class="form-control" >			
			<textarea id='editor1' name="editor1" ></textarea>
			<script>
				CKEDITOR.replace('editor1', {
					filebrowserUploadUrl : 'uploadFile',
						height: '450px'
				});
			</script>
			<button id="test1" class="btn btn-success" style="width: 1200px;">저장</button>
			<input type="hidden" name="sName" value="${sName }">
		</form>
	</div>
	${url }
</body>
</html>