<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">

.title-font{
	font-size: 25pt;
	float: left;
	margin-left: 50px;
}

.clear-both{
clear: both;
}

#boardContent{
	border: 0px solid red;
	margin-left: 50px;
	margin-right: 50px;
	font-size: 18pt;
}

</style>

<title></title>
<script src="https://cdn.ckeditor.com/4.7.2/standard/ckeditor.js"></script>

<script type="text/javascript">
	function deleteBoard(idx){
		
		swal({
			  title: '정말 삭제하겠습니까?',
			  text: "정말 삭제?????!",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '삭제!',
			  cancelButtonText: '취소!',
			  confirmButtonClass: 'btn btn-success',
			  cancelButtonClass: 'btn btn-danger',
			  buttonsStyling: false
			}).then(function () {
			  swal({
			   text: '삭제에 성공하였습니다.',			  
			  }).then(function(){
				  location.href= 'delete/' + idx;
			  })
			}, function (dismiss) {
			  // dismiss can be 'cancel', 'overlay',
			  // 'close', and 'timer'
			  if (dismiss === 'cancel') {
			    swal(
			      '취소하셨습니다.'
			    )
			  }
			})
		
		
		//location.href= 'delete/' + idx;
	}
</script>

</head>
<body>
	<div id="boardGroup" style="width: 1200px;height:700px; margin: auto; background-color:white;
	 border: 1px solid black; border-radius: 10px; padding: 70px; overflow: auto; padding: 20px;" >
	 
	 <div class="form-group">
	 	<div class="title-font">제목</div>
	 	<div class="title-font">${vo.title }</div>
	 	<div style="float: right;">
		 	<button class="btn btn-success">수정</button>
		 	<button class="btn btn-info" onclick="deleteBoard(${vo.pv_board_idx})">삭제</button>	 	
	 	</div>
	 </div>
	 <hr class="clear-both">
	 <div id="boardContent" class="form-group">
	  	${vo.content }
	  </div>
	<!-- <pre><textarea rows="34" cols="220">	${vo.content }</textarea></pre>-->
	</div>
</body>
</html>