import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //Fetchong from HTML form
        String a1=request.getParameter("cardno");
        String a2=request.getParameter("edate");
        String a3=request.getParameter("cvv");
        String a4=request.getParameter("cname");
        String a5=request.getParameter("enum");
        String a6=request.getParameter("ename");
        
        //Connection to database
        try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "system";
                 String pass = "pass123";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into card values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 con.commit();
                 con.close();
                 RequestDispatcher rd=request.getRequestDispatcher("Payment.html");
                 rd.forward(request,response);  
                 
                 
            }catch(Exception exe){System.out.println("Exception caught"+exe);
            }
    }
}
    