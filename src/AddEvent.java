import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddEvent extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        //Fetching data from HTML form
        String a1=request.getParameter("EventNo");
        String a2=request.getParameter("EventName");
        String a3=request.getParameter("coordinatorName");
        String a4=request.getParameter("CoordinatorNo");
        String a5 =request.getParameter("fee");
        String a6=request.getParameter("venue");
        String a7=request.getParameter("date");
        
        //Connection to Database
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "pass123";
            Connection con = DriverManager.getConnection(conURL, user, pass);//Establish Connection
            
            Statement stmt=con.createStatement();
            String Qs="insert into Event values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"') ";
            ResultSet rs=stmt.executeQuery(Qs);
                 
            RequestDispatcher rd=request.getRequestDispatcher("CreateE.html");
            rd.include(request, response);
                 
            out.println("<br><center><h3> Event Added</h3></center>");
            System.out.println("Added to database!");
            con.commit();
            con.close();
            }catch(Exception exe){System.out.println("Exception caught"+exe);}
        }
    }



