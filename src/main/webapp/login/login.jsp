<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
  <meta charset="utf-8">
    <title>Login</title>
    
<!--     <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"> -->
    <link rel="stylesheet" href="/css/login.css">

</head>
<div id="login">
	<h2>LogIn</h2>
	<form name='form-login' action="/loginServlet" method="post">
		<span class="fontawesome-user"></span>
		<input type="text" id="userId" name="userId" placeholder="Username" required>
		
		<span class="fontawesome-lock"></span>
		<input type="password" id="password" name="password" placeholder="Password" required>
		
<!-- 		<label> -->
<!-- 			<input type="checkbox" id="rememberMe" name="rememberMe" placeholder="rememberMe" required> Remember me -->
<!-- 		</label> -->
		<input type="submit" value="Login">

	</form>
</div>