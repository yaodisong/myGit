<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<script src="../../resources/jquery/2.0.0/jquery.min.js">//引入jquery框架

</script>
<body>
	<form action="login" method="post">
	      用户名:<input type="text" name="userName" id="username"/><br>
	      密   码:<input type="password" name="passWord" id="password"/><br>
	       <button onclick="login()">登录</button>
    </form>
</body>
<script type="text/javascript">
	var userName = $("#username").val();
	var pwd = $("#password").val();
	function login(){
		$.ajax({
			type:"post",
			url:basePath+"User/login",
			data:{
				userName:username,
				passWord:pwd
			},
			dataType:"json",
			success:function(msg){
				alert(msg); 
			},
			error:function(){
				alert("failed");
			}
		});
	}
</script>
</html>



































