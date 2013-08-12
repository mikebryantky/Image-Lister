<%@ page language="java" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Image Lister</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    
    <link href="css/base.css" rel="stylesheet">
    <link href="css/custom-theme/jquery-ui-1.10.3.custom.css" rel="stylesheet">
    <link rel="stylesheet" href="fancybox/source/jquery.fancybox.css?v=2.1.4" type="text/css" media="screen" />
    <link rel="stylesheet" href="fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
    <link rel="stylesheet" href="fancybox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
    
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
    <script type="text/javascript" src="fancybox/source/jquery.fancybox.pack.js?v=2.1.4"></script>
    <script type="text/javascript" src="fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <script type="text/javascript" src="fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.5"></script>
    <script type="text/javascript" src="fancybox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>
    
    <script type="text/javascript">
        $(function() {
            $(".button").button();
            $("input[type=submit]").button();
            $("input[type=reset]").button();
            
            $(".fancybox").fancybox();
        });
    </script>
</head>
<body>

<div id="outer" class="ui-corner-all">
    <div id="header">
        <div>
            &nbsp;
        </div>
        <div style="padding-left: 110px; position: relative; top: -30px;">
            <jsp:include page="/menu.jsp"></jsp:include>
        </div>
    </div>
    
    <div style="clear: both;"></div>
    
    <div id="inner">
        <div id="loadingMessage"></div>
        