<!-- exam.jsp --> 
<!DOCTYPE html> 
<html> 
<head> 
<title>Online Exam</title> 
</head> 
<body> 
<form action="ExamServlet" method="post"> 
<h2>Online Exam</h2> 
<p>Question 1: What is the capital of France?</p> 
<input type="radio" name="answer" value="A"> A) Paris<br> <input type="radio" name="answer" value="B"> B) Rome<br> <input type="radio" name="answer" value="C"> C) Berlin<br> 
<input type="radio" name="answer" value="D"> D) Madrid<br> <br> 
<input type="submit" value="Submit Exam"> 
</form> 
</body> 
</html> 
<servlet> 
<servlet-name>ExamServlet</servlet-name> 
<servlet-class>your.package.name.ExamServlet</servlet-class> </servlet> 
<servlet-mapping> 
<servlet-name>ExamServlet</servlet-name> 
<url-pattern>/ExamServlet</url-pattern> 
</servlet-mapping>
