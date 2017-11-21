<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:getAsString name="title" /></title>
    
    <link rel="stylesheet" href="./resources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,80">
    <link rel="stylesheet" href="./resources/assets/css/styles.css">
    <link rel="stylesheet" href="./resources/assets/css/Pretty-Header.css">
    <link rel="stylesheet" href="./resources/assets/css/Pretty-Footer.css">
    <link rel="stylesheet" href="./resources/assets/css/Simple-Profile-Info.css">
    
    <link rel="stylesheet" href="./resources/assets/css/Google-Style-Login.css">
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<!-- fotorama.css & fotorama.js. -->
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.0/sweetalert2.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.0/sweetalert2.min.js"></script>


<style type="text/css">
 * { box-sizing: border-box; }
    .video-background {
        background: #000;
        position: fixed;
        top: 0; right: 0; bottom: 0; left: 0;
        z-index: -99;
        max-width:100%;
          max-height:100%;
    }
    .video-foreground,
    .video-background iframe {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        pointer-events: none;
    }
    @media (min-aspect-ratio: 16/9) {
    .video-foreground { height: 300%; top: -100%; }
    }
    @media (max-aspect-ratio: 16/9) {
    .video-foreground { width: 300%; left: -100%; }
    }
    h1{ color:white;}


html {
height: 100%;
}
body {
margin: 0;
height: 100%;
}
header {
background-color: #EFEFEF;
}

ol {
margin: 0;
}
footer {
position: absolute;
bottom: 0;
left: 0;
right: 0;
color: white;
background-color: #333333;
}

</style>

</head>

<body>
  
    <header id="header"  >
		<tiles:insertAttribute name="header"/>
	</header>
	<section id="siteContent"  style="margin: 0 auto;">
		<tiles:insertAttribute name="body" />
	</section>

	<footer id="footer" class="text-muted"  >
		<tiles:insertAttribute name="footer" />
	</footer>

    
   
    <script src="./resources/assets/js/jquery.min.js"></script>
    <script src="./resources/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>