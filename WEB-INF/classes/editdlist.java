import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class editdlist extends HttpServlet {

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
	    
		
		String sq="SELECT c.title,c.actor,a.catagory from dvds c,dvdcat a where c.catagory_id=a.id and  a.catagory like '%'";
		 try{
	     ResultSet r;
	r=ob.getResultSet(sq);
			    
			    out.println("<form action='' method='get'>");
			    out.println("<div align ='center'>");
			    out.println("<select name='dvds'>");
			 
			    
	    while(r.next()){
		      out.println("<option >"+r.getString("title")+"</option>");
		    
	    }
	      out.println("</select>");
	out.println("<input type='submit' name='submit' value='Modify' />");
	out.println("</div>");
	out.println("</form>");
          }catch(Exception e)
          {
	    
	}
	String submit="";
	submit=request.getParameter("submit");
	String dvds="";
	dvds=request.getParameter("dvds");
	if(submit.equals("Modify"))
	{
	
		String sql3="SELECT * from dvds where title like '%"+dvds+"'";
		
	
		    try{
	    
	ResultSet rc=ob.getResultSet(sql3);
			    
			    out.println("<form action='' method='post'>");
			    out.println("<div align ='center'>");
			    out.println("<input type='text'  value='ID'disabled/>");
			 out.println("<input type='text'  value='Title' disabled/>");
			 out.println("<input type='text'  value='Actor/Actress' disabled/>");
			 out.println("<input type='text'  value='Category Id' disabled />"+"<br />");
			    
	    while(rc.next()){
		      
		      
			 
			
		    
		    
			 out.println("<input type='text' name='id' value='"+rc.getString("id")+"'readonly/>");
			 out.println("<input type='text' name='title' value='"+rc.getString("title")+"'/>");
			 out.println("<input type='text' name='actor' value='"+rc.getString("actor")+"'/>");
			 out.println("<input type='text' name='catagory' value='"+rc.getString("catagory_id")+"'/>");
		    out.println("<br />");
		    
		    
	    }
	    
	out.println("<input type='submit' name='edit' value='edit' />");
	out.println("</div>");
	out.println("</form>");
          }catch(Exception e)
          {
	    
	}
	
}
      
    
	    //out.println("hi  "+d);
	    
    }
    else
    response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
    
    
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
	    
	    
	String sub="";
	sub=request.getParameter("edit");
	
	 String title=request.getParameter("title");
	 String actor=request.getParameter("actor");
	 String id=request.getParameter("id");
	 int catagory_id=Integer.parseInt(request.getParameter("catagory"));
	 String stm="update  dvds set title='"+title+"', actor='"+actor+"' ,catagory_id="+catagory_id+" where id='"+id+"'";
	 try{
	ob.executeQuery(stm);
		 //out.println(stm);
	 }catch(Exception e)
	 {
		 
		 }
	out.println("<center><h1>updated </h1></center>");
    }
    }
    }