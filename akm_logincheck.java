    // CHECK FOR USERNAME AND PSW..  SERVELET //
	
	import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 import java.util.*;
   import java.sql.*;

public class logincheckk extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	
	
    throws IOException, ServletException
    {
		String Name=""; String password="";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean b1=false;
	
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");
		
		
		 try 
		  {
			  Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/akmproject";

            Connection conn = DriverManager.getConnection(url,"root","");  

            Statement stmt = conn.createStatement();   
			
			
           ResultSet rs;
		   
		   
		 
          rs = stmt.executeQuery("SELECT * FROM akm WHERE `USERNAME`='"+s1+"' AND `PASSWORD`='"+s2+"'");
			 
			  while ( rs.next() ) 
			  {              // rs.next --- until values are present //
                 Name = rs.getString("USERNAME");
                
				 password = rs.getString("PASSWORD");
				 b1=true;
			  }
			  
			   conn.close(); 	
		   }
		   
           catch (Exception e)
		   {
            System.out.println("Got an exception! ");
            System.out.println(e);
           } 
			  
		 
		 if(b1)
		 {  
	 
	  out.print("login successfull"); 
       // RequestDispatcher rd=request.getRequestDispatcher("loginserveletk");     // DASHBOARD -- changes to be done //
       // rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry UserName or Password Error!"); 
        out.println("<br>");		
		out.println("<br>");	
		out.println("<br>");	
       // RequestDispatcher rd=request.getRequestDispatcher("cmaservelet");  
      //  rd.include(request, response);  
                      
        }  
				
		   
	}
}