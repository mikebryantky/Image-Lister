<%@ page language="java" import="java.util.*, java.io.*, com.millcreeksoftware.imglister.*" pageEncoding="ISO-8859-1"%>
<%
    if(session.getAttribute("loginData") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    
	LoginData loginData = (LoginData) session.getAttribute("loginData");
	String userName =  loginData.getUserName();
	String baseDir = loginData.getBaseDir();
	
    String curDir = baseDir;
    String dirParam = request.getParameter("dir");
    if(dirParam != null && dirParam != "") {
       if(dirParam.startsWith(baseDir)) {
         curDir = dirParam;
       }
    }
%>


<jsp:include page="header.jsp"></jsp:include>  
	
	<style type="text/css">
	   .placeholder {
	       width: 150px;
	       height: 150px;
	       border: solid thin #999999;
	       clear:none;
	       float: left;
	       margin: 5px;
	       position:relative;
	       text-align: center;
	   }
	   
	   .placeholder img {
	       border: none;
	       margin: 0px;
	       padding 0px;
	   }
	   
       .placeholderText {
           width: 100%;
           text-align: center;
           position: absolute; 
           bottom: 0;
           padding: 2px;
       }
       
       .deleteRow {
           margin-yop: 5px;
       }
	</style>
</head>
 
<body>

<form id="listForm" action="delete" method="post">
    <input type="hidden" name="curDir" value="<%= curDir %>" />
    
	<%
		File directory = new File(curDir);
		File[] fList = directory.listFiles();
		for (File file : fList) {
		   if(file.isDirectory()) {
		       %> 
		          <div class="placeholder">
		              <a href="list.jsp?dir=<%= curDir + "/" + file.getName() %>"><img src="images/folder_icon.png" /></a>
		              <div class="placeholderText">
		                  <a href="list.jsp?dir=<%= curDir + "/" + file.getName() %>"><%= file.getName() %></a>
		              </div>
		          </div> 
		       <%
		   } else if(file.getName().toLowerCase().indexOf(".jpg") > 0) {
		       %> 
		          <div class="placeholder">
		              <a class="fancybox" rel="group" href="displayImage?fileName=<%= curDir + "/" + file.getName() %>"><img src="displayThumbnail?fileName=<%= curDir + "/" + file.getName() %>" alt="<%= file.getName() %>" /></a>
		              <div style="clear: both;"></div>
		              <br />
		              <input type="checkbox" class="deleteRow" name="checkedRows" value="<%= file.getName() %>" />&nbsp;<%= file.getName() %>
		          </div> 
		       <%
		   }
		}
	%>

	<div style="clear: both;"></div>
	<br />
	<a href="list.jsp" class="button">Back to top</a> &nbsp;|&nbsp;
	<input type="button" id="selectAllBtn" name="selectAll" value="Select All Images" />&nbsp;|&nbsp;
	<input type="submit" value="Delete Selected Images" />&nbsp;|&nbsp;
	<a href="logout" class="button">Logout</a>
</form>


<script type="text/javascript">
    $(function() {
        $("#selectAllBtn").button().click(function() {
            $(".deleteRow").each(function() {
                this.checked = true;
            });
        });
    });
</script>

<jsp:include page="footer.jsp"></jsp:include>
