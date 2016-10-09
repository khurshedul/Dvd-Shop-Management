import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	    response.setContentType("text/html");
        DataAccess ob=new DataAccess();
        PrintWriter out = response.getWriter();
       	HttpSession session = request.getSession();
	session.invalidate();
	response.sendRedirect("main");
	out.close();  
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	
    }
}