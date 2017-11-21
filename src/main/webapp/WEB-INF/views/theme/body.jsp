<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

 
<style type="text/css">
    .fotorama__html{position:relative !important;}
    .fotorama__html div{height:100%;}
    .fotorama__html a{z-index:1; display:block; height:100%;}
</style>
 

</head>
<body>
<div>
<div class="video-background">
    <div class="video-foreground">
      <iframe src="https://www.youtube.com/embed/_SPPh5ugFlg?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=_SPPh5ugFlg" frameborder="0" allowfullscreen></iframe>
    </div>
  </div>
	

	<script type="text/javascript">
		/* $(document).ready(function(e) {
			   $(".fotorama").on("click",function(){
			       
			  var href = $(this).find("a").attr('href');
			  location.href=href;
			       
			  });  
		}); */
	</script>
	<div>
		<div class="fotorama"  data-autoplay="3000"
		data-click='false' data-swipe='false' data-width="100%"
			data-height="100%"  data-maxheight="700"  style="margin: 0 auto;">
			<c:forEach items="${imgList }" var="i">
			<!-- dsfsdfsdfsdafsd -->
<%-- 				<div data-img='./resources/file/${i.savefilename }'><a href='selectByIdx?idx=${i.pv_board_idx }'>sdfsdf</a></div> --%>
				<div data-img='./resources/file/${i.savefilename }'></div>
			</c:forEach>
			
			<!-- <div data-img='./resources/file/test1.png'><a href='selectByIdx?idx=16'>fdsf</a></div>
			<div data-img='./resources/file/test2.png'><a href='./resources/file/test2.png'>dsf</a></div> -->
		</div>
	</div>
</div>
</body>
</html>