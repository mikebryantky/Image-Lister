
<jsp:include page="header.jsp"></jsp:include> 

    <style type="text/css">
       #loginForm {
           width: 450px;
           height: 100px;
           border: solid thin #999999;
           text-align: center;
           margin-left: auto;
           margin-right: auto;
           margin-top: 100px;
       }
       
       label {
           width: 150px;
           text-align: left;
           display: inline-block;
       }
       
       input {
           margin-top: 5px;
           display: inline-block;
       }
    </style>

<form id="loginForm" action="login" method="post">
    <div>
		<label>User Name:</label>
		<input name="userName" type="text" />
	</div>
	<div>
		<label>Password:</label> 
		<input name="password" type="password" />
	</div>
	
	<input type="submit" value="Login">
</form>

<jsp:include page="footer.jsp"></jsp:include>
