import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
      
        PrintWriter out = response.getWriter();
        String s="<html> <center>"+
	    " <head>"+
		     "<style>.divtopcorner{ position:absolute;top:0px;right: 150px;color:black;text-align:center;padding:5px;}.header{color:black;text-align:center;padding:5px;}.manulist{display:inline;left:100px;}.menulista {background-color: black;color: white;padding: 10px 20px;text-decoration: none;border-radius: 4px 4px 0 0;}.menulista:hover {background-color: orange;}</style>"+
		"</head>"+
    "<body>"+
	    " <div class='header'><h1>DVD Shop Management System</h1></div>"+
			  "<div class='divtopcorner'>"+
				    "<img src='dvd.png' height='150' width='150' alt='DVD Shop Management System'/>"+
				"</div>"+
			"<br/><br/>"+
				"<ul><hr />"+"<body>"
	    + "<script src=\"loginValidate.js\"></script>"
        +"<form action=\"\" method=\"post\" onsubmit='return loginValidate();'>"
        +"User NAme: <input type=\"text\" name=\"user\" id=\"myid\"   placeholder='User Name'>"
		+"<br />"
		+"Password: <input type=\"password\" name=\"pass\" id=\"mypassword\"  placeholder='password'>"
		+"<br />"
        +"<input type=\"submit\" value=\"Submit\" />"
        +"</form>"
        +"</body>"
        +"</center> </html>";
		out.println(s);
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	HttpSession session = request.getSession(true);
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	DataAccess ob=new DataAccess();
	String id=request.getParameter("user");
	String name=request.getParameter("pass");
	session.setAttribute("username",id);		
			
	//String sql="insert into students values ('"+id+"','"+name+"',"+Double.parseDouble(cgpa)+","+Integer.parseInt(did)+")";
	//if(ob.executeQuery(sql)){
	///out.println(id+","+name);
	    try{
		    String sql="select * from  users where user_name='"+id+"' and password='"+name+"'";
		    
	    ResultSet r=ob.getResultSet(sql);
	    while(r.next()){
		   String st= r.getString("type");
		    session.setAttribute("usertype",st);	
		    if(st.equals("admin"))
			response.sendRedirect("Adminindex");
		    else if(st.equals("user"))
			response.sendRedirect("user");
		   
		     }
	    
	    }catch(Exception e )
	    {
		    }
		    
		    	   
		  //  out.println("<center> login failed Check your username or password </center>  </ br>");
		  //  out.println("<a class ='menulista' href='main'>Login Again</a> </ br>");
			    String s="<html> <center>"+
		    " <head>"+
		     "<style>.divtopcorner{ position:absolute;top:0px;right: 150px;color:black;text-align:center;padding:5px;}.header{color:black;text-align:center;padding:5px;}.manulist{display:inline;left:100px;}.menulista {background-color: black;color: white;padding: 10px 20px;text-decoration: none;border-radius: 4px 4px 0 0;}.menulista:hover {background-color: orange;}</style>"+
		"</head>"+
    "<body>"+
	    " <div class='header'><h1>DVD Shop Management System</h1></div>"+
			  "<div class='divtopcorner'>"+
				    "<img src='dvd.png' height='150' width='150' alt='DVD Shop Management System'/>"+
				"</div>"+
			"<br/><br/>"+
				"<ul><hr />"
		+"<body>"+
		    "<center> login failed Check your username or password </center>  </ br>"
	    + "<script src=\"loginValidate.js\"></script>"
        +"<form action=\"\" method=\"post\" onsubmit='return loginValidate();'>"
        +"User NAme: <input type=\"text\" name=\"user\" id=\"myid\"   placeholder='User Name'>"
		+"<br />"
		+"Password: <input type=\"password\" name=\"pass\" id=\"mypassword\"  placeholder='password'>"
		+"<br />"
        +"<input type=\"submit\" value=\"Submit\" />"
        +"</form>"
        +"</body>"
        +"</center> </html>";
		out.println(s);
		    
		   
	}
	

	
    }
