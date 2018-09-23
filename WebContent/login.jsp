<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
 
    <link rel="stylesheet" type="text/css" href="login.css"/>
    <script type="text/javascript" src="login.js"></script>
</head>
 
<body>
<div id="login_frame">
 
    <p id="image_logo"><img src="images/profile.jpg" width="100px" height="100px"></p>
 
    <form  action="LoginServlet" method="post">
    <div>
        <p><label class="label_input">用户名</label><input type="text" name="username" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>
 
        <div id="login_control">
	        <input type="submit" id="btn_login" value="登录" />
	        <a id="forget_pwd" href="#">忘记密码？</a>
        </div>
     </div>
    </form>
</div>
 
</body>
</html>