<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

       <h1>Signup</h1>
        <hr>
        
        <a href="index.jsp">Back</a>
        
        <hr>
        
        <form action="SignupFormServlet" method="post">
        
        <p style="color: red">${Message} </p> 
         
             FirstName <input type="text" name="fname"><br><br>
             LastName <input type="text" name="lname"><br><br>
             UserName <input type="text" name="username"><br><br>
             Password <input type="password" name="password"><br><br>
             
                       <input type="submit" value="Signup">
        
        </form>

</body>
</html>