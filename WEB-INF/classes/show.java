import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class show extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	    response.setContentType("text/html");
        DataAccess ob=new DataAccess();
        PrintWriter out = response.getWriter();
        /*String s="<html>"
		+"<body>"
        +"<form action=\"HelloForm\" method=\"post\">"
        +"ID: <input type=\"text\" name=\"id\">"
		+"<br />"
		+"Name: <input type=\"text\" name=\"s_name\">"
		+"<br />"
        +"CGPA: <input type=\"text\" name=\"cgpa\" />"
		+"<br />"
		+"DID: <input type=\"text\" name=\"did\">"
		+"<br />"
        +"<input type=\"submit\" value=\"Submit\" />"
        +"</form>"
        +"</body>"
        +"</html>";
		out.println(s);*/
		//out.println("hello");
		try{
		ResultSet r=ob.getResultSet("select * from products");
		out.println("<center>");
		out.println("<table border=\"3\">");
		out.println("<tr>");
		out.println("<th>");
		out.println("Id");
		out.println("</th>");
		out.println("<th>");
		out.println("name");
		out.println("</th>");
		out.println("<th>");
		out.println("cgpa");
		out.println("</th>");
		out.println("<th>");
		out.println("dept");
		out.println("</th>");
		out.println("</tr>");
		
		
		
		
		
		while(r.next()){
		out.println("<tr>");
		out.println("<td>");
		out.println(r.getString("p_id"));
		out.println("</td>");
		out.println("<td>");
		out.println(r.getString("p_name"));
		out.println("</td>");
		out.println("<td>");
		out.println(r.getString("price"));
		out.println("</td>");
		out.println("<td>");
		out.println(r.getString("quantity"));
		out.println("</td>");
		out.println("</tr>");
		}
		
		
		
		}catch(Exception e){
		
		}
		out.println("</table>");
		out.println("</center>");
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	
    }
}