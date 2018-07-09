<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
   <title>登录首页</title>
</head>
<body>
     <!--  action 提交给那个servlet处理数据 
     
          doPost()
          doGet()
     -->  
     
     
     <form action="/LoginServlet_login.do"  method="get">
                 姓名:<input type="text" name="name"/><br>
                 密码:<input type="password" name="password"/><br>
          1: <input type="checkbox" name="hobby" value="1"/><br>
          2:<input type="checkbox" name="hobby" value="2"/><br>
          3:<input type="checkbox" name="hobby" value="3"/><br> 
           <input type="submit" value="登录"/>        
     </form>

</body>
</html>