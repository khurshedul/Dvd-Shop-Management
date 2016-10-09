import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class requests extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
		HttpSession session = request.getSession(true);
	    PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
		String d=session.getAttribute("username").toString();
		String sql="select * from  users where user_name='"+d+"'";
	    DataAccess ob=new DataAccess();
	    String st="";
	    try{
	     ResultSet r=ob.getResultSet(sql);
	    while(r.next()){
		 st  = r.getString("type");
		    
		    
	    }
    }catch(Exception e)
    {
	    
    }
    if(st.equals("admin"))
    {
	    
	/*if(logval!="admin"){
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/main");
			//PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
	   }*/
	  
	   
	  //  out.println(logval);
	    String a="<html>"+
	    " <head>"+
		     "<style>.divtopcorner{ position:absolute;top:0px;right: 150px;color:black;text-align:center;padding:5px;}.header{color:black;text-align:center;padding:5px;}.manulist{display:inline;left:100px;}.menulista {background-color: black;color: white;padding: 10px 20px;text-decoration: none;border-radius: 4px 4px 0 0;}.menulista:hover {background-color: orange;}</style>"+
		"</head>"+
    "<body>"+
	    " <div class='header'><h1>DVD Shop Management System</h1></div>"+
			  "<div class='divtopcorner'>"+
				    "<img src='dvd.png' height='150' width='150' alt='DVD Shop Management System'/>"+
				"</div>"+
			"<br/><br/>"+
				"<ul>"+
				    "<li class='manulist'>"+
						    "<a class ='menulista' href='dvdadd'>Add Dvd</a>"+
						    "<a class ='menulista' href='dvdedit'>Modify Dvd</a>"+
						    "<a class ='menulista' href='dvdcedit'>Modify Category</a>"+
						    "<a class ='menulista' href='catadd'>Add Category</a>"+
						    "<a class ='menulista' href='listdvd'>Dvd List</a>"+
						    "<a class ='menulista' href='search'>Search Dvd</a>"+
						    "<a class ='menulista' href='cngpassa'>Change password  </a>"+
						    "<a class ='menulista' href='users'>View User Data  </a>"+
						    "<a class ='menulista' href='usersearch'>Search User </a>"+
						    "<a class ='menulista' href='usrreq'>View User Requests </a>"+
								"<div align='center'>"+
								"<h4>Hi!"+ d+"</h4>"+
								 "<a class ='menulista' href='logout'>Logout</a>"+   
						"    </div>"+
						"</li>"+
				"</ul>"+
			  "<hr />"+
		"</body>"+
	    "</html>";
	    out.println(a);
	    
		
		String sql3="SELECT c.id,a.name,c.requests FROM `requests` c, users a  WHERE c.userid=a.user_name";
		
		 out.println("<table align='center' border='2' > ");
		 out.println("<tr>");
		 out.println("<th>"+"ID"+"</th>");
		 out.println("<th>"+"Name"+"</th>");
		 out.println("<th>"+"Requests"+"</th>");
		 out.println("</tr>");
		    try{
	     ResultSet r;
	r=ob.getResultSet(sql3);
	    while(r.next()){
		    //out.println("jkjhjkh");
		      out.println("<tr>");
			 out.println("<td>"+r.getString("id")+"</td>");
			 out.println("<td>"+r.getString("name")+"</td>");
			 out.println("<td>"+r.getString("requests")+"</td>");
		    out.println("</tr>");
		    
		    
	    }
	   
	     out.println("</table>");
          }catch(Exception e)
          {
	    
	}
	
	
    
	    //out.println("hi  "+d);
	    
    }
    else
    response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
    }