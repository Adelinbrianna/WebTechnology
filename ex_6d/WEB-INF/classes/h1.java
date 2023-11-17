import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class h1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String n=request.getParameter("userName");
        String ps=request.getParameter("sport");  
        out.print("Welcome "+n+", and your favourite pets is"+ps);   
        HttpSession session=request.getSession();  
        session.setAttribute("login_name",n);
        session.setAttribute("fav_pet",ps);  
        out.print("<a href='dine'>visit</a>");           
        out.close(); 
        }catch(Exception e){System.out.println(e);}  
    }
}  
