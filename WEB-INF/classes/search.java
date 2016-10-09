import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class search extends HttpServlet {

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
	    String s="<html> <center>"
		+"<body>"
        +"<form action=\"\" method=\"get\">"
        +"Search Dvds: <input type=\"text\" name=\"search\" id=\"myid\"   placeholder='Search Dvds'>"
        +"<input type=\"submit\" value=\"Search\" name='submit' />"
        +"</form>"
        +"</body>"
        +"</center> </html>";
		out.println(s);
		
	String search="";
	String submit="";
	submit=request.getParameter("submit");
	search=request.getParameter("search");
	String output="";
	int count=0;
	if(submit.equals("Search"))
	{
		String sql3="SELECT c.title,c.actor,a.catagory from dvds c,dvdcat a where c.catagory_id=a.id and  a.catagory like '%"+search+"%'";
		String sql1="SELECT c.title,c.actor,a.catagory from dvds c,dvdcat a where c.catagory_id=a.id and  c.actor like '%"+search+"%'";
		String sql2="SELECT c.title,c.actor,a.catagory from dvds c,dvdcat a where c.catagory_id=a.id and  c.title like '%"+search+"%'";
		 out.println("<table align='center' border='2' > ");
		 out.println("<th>"+"Title"+"</th>");
		 out.println("<th>"+"Actor"+"</th>");
		 out.println("<th>"+"Catagory"+"</th>");
		    try{
	     ResultSet r=ob.getResultSet(sql3);
	    while(r.next()){
		      out.println("</tr>");
			 out.println("<td>"+r.getString("title")+"</td>");
			 out.println("<td>"+r.getString("actor")+"</td>");
			 out.println("<td>"+r.getString("catagory")+"</td>");
		    out.println("</tr>");
		    count++;
		    
		    
	    }
	     r=ob.getResultSet(sql2);
	    while(r.next()){
		  out.println("</tr>");
			 out.println("<td>"+r.getString("title")+"</td>");
			 out.println("<td>"+r.getString("actor")+"</td>");
			 out.println("<td>"+r.getString("catagory")+"</td>");
		    out.println("</tr>");
		    count++;
		    
	    }
	    r=ob.getResultSet(sql1);
	    while(r.next()){
		 out.println("</tr>");
			 out.println("<td>"+r.getString("title")+"</td>");
			 out.println("<td>"+r.getString("actor")+"</td>");
			 out.println("<td>"+r.getString("catagory")+"</td>");
		    out.println("</tr>");
		    count++;
		    
	    }
	     out.println("</table>");
	    
          }catch(Exception e)
          {
	    
	}
	if (count<1)
	{
		out.println("<div align='center'>Not found </div>");
		}
	
	}
    
	    //out.println("hi  "+d);
	    
    }
    else
    response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
    }