import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet("/EmployeeServlet") 
public class EmployeeServlet extends HttpServlet { 
private static final long serialVersionUID = 1L; 
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
String action = request.getParameter("action"); 
if ("insert".equals(action)) { 
insertEmployee(request, response); 
} else if ("update".equals(action)) { 
updateEmployee(request, response); 
} 
} 
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
String action = request.getParameter("action"); 
if ("view".equals(action)) {
viewEmployees(request, response); 
} 
} 
private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
// Get parameters from the request 
String name = request.getParameter("name"); 
int age = Integer.parseInt(request.getParameter("age")); String designation = request.getParameter("designation"); 
// JDBC Connection 
try { 
Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password"); 
// Insert Query 
String insertQuery = "INSERT INTO employee (name, age, designation) VALUES (?, ?, ?)"; 
try (PreparedStatement preparedStatement = 
conn.prepareStatement(insertQuery)) { 
preparedStatement.setString(1, name); 
preparedStatement.setInt(2, age); 
preparedStatement.setString(3, designation); 
preparedStatement.executeUpdate(); 
} 
conn.close(); 
response.sendRedirect("index.jsp"); // Redirect to a success page } catch (SQLException e) { 
e.printStackTrace();
// Handle exceptions 
} 
} 
private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
// Similar to insert, but with an update query 
} 
private void viewEmployees(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
// JDBC Connection 
try { 
Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password"); 
// Select Query 
String selectQuery = "SELECT * FROM employee"; 
try (PreparedStatement preparedStatement = 
conn.prepareStatement(selectQuery); 
ResultSet resultSet = preparedStatement.executeQuery()) { PrintWriter out = response.getWriter(); 
out.println("<html><body>"); 
// Display results 
while (resultSet.next()) { 
out.println("ID: " + resultSet.getInt("id") + "<br>"); 
out.println("Name: " + resultSet.getString("name") + "<br>"); out.println("Age: " + resultSet.getInt("age") + "<br>"); 
out.println("Designation: " + resultSet.getString("designation") + "<br><hr>"); 
}
out.println("</body></html>"); 
} 
conn.close(); 
} catch (SQLException e) { 
e.printStackTrace(); 
// Handle exceptions 
} 
} 
} 
