import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ExamServlet") 
public class ExamServlet extends HttpServlet { 
private static final long serialVersionUID = 1L; 
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
// Get answers submitted by the student 
String[] submittedAnswers = request.getParameterValues("answer"); 
// Evaluate the answers (Assuming correct answers are known) int score = evaluateAnswers(submittedAnswers); 
// Display the score 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
out.println("<html><body>"); 
out.println("<h2>Your Exam Result</h2>"); 
out.println("<p>Score: " + score + "</p>"); 
out.println("</body></html>"); 
} 
private int evaluateAnswers(String[] submittedAnswers) { 
// Implement your logic to compare submitted answers with correct answers 
// For simplicity, let's assume each correct answer gives 1 point int score = 0; 
String[] correctAnswers = {"A", "B", "C", "D"}; 
for (int i = 0; i < submittedAnswers.length; i++) { 
if (submittedAnswers[i].equals(correctAnswers[i])) { 
score++; 
}
} 
return score; 
} 
} 

