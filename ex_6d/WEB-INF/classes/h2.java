import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;    
public class h2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("login_name");
        String SP=(String)session.getAttribute("fav_pet");    
        out.print("Hello!! Welcome Back "+n+"and your favourite pet is "+SP);  
        out.close();  
        }catch(Exception e){System.out.println(e);}  
    }
}  
