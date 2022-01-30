import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class VaPa extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    
    //Fetching data  from HTML form
    String n=request.getParameter("Pausername");  
    String p=request.getParameter("Papassword");  
          
    if(LoginDao.validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("ParticipantEvent.html");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("<center><h1>Sorry username and password incorrect</h1></center>");  
        RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");  
        rd.include(request,response);  
    }  
    out.close();  
  }  
}  