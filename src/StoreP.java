import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class StoreP extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        //Fetching data from Psignup.html from user
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname"); 
        
        // Asign to another strings 
        
        String a1=up;
        String a2=pp;
        String a3=cp;
        String a4 =name;
        
        
        if(a2.equals(a3)){
            //Connection & storing into Database
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "system"; // Username of  database
                 String pass = "pass123"; //Password for system
                 // Create connection
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 
                 Statement stmt=con.createStatement();
                 //SQL statment
                 String Qs="insert into plogindeatils values('"+a1+"','"+a2+"','"+a4+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");
                 rd.forward(request, response);
                 con.close();
                 
            }catch(Exception exe){System.out.println(exe);}
             
        }
        else
        {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }
            
        
    }

}