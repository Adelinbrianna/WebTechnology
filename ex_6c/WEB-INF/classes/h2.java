import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class h2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();            
        String n=request.getParameter("names");
        String PS=request.getParameter("pets");  
  
        out.print("Hello! Welcome back "+n+"and your favourite pet is"+PS);  
        out.close();  
        }catch(Exception e){System.out.println(e);}  
    } 
}
