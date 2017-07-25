package com.spring;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.searchbean;
import com.google.gson.Gson;

import pkgdbconnection.db_search;

@Controller
public class Scontroller {
	
	private static final long serialVersionUID = 1L;
	@RequestMapping(value="/search",method=RequestMethod.GET)
	   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	   {

	           response.setContentType("application/json");
	           try {
	                   String term = request.getParameter("searchbox");
	           	//String term =searchBean.getSearch();
	                   System.out.println("Data from ajax call " + term);

	                   db_search dataDao = new db_search();
	                   ArrayList<String> list = dataDao.getNames(term);
	                   System.out.println("list:"+list);
	                  
	                  // System.out.println("listsize:"+count);
	                   String searchList = new Gson().toJson(list);
	                   response.getWriter().write(searchList);
	                   System.out.println("names:"+searchList);
	                  // System.out.println("size:"+searchList.length());
	           } catch (Exception e) {
	                   //System.err.println(e.getMessage());
	           }
	   }
	 
@RequestMapping(value="/addfriend",method=RequestMethod.GET)

public ModelAndView Addfriend(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
{
	 
	HttpSession session1=request.getSession();
	session1.getAttribute("userid");
	int Uid=(Integer) session1.getAttribute("userid");
	 System.out.println("userid"+session1.getAttribute("userid"));
	 System.out.println("id1:"+id);
	db_search obj= new db_search();
	obj.inserting(Uid,Uid,id,0,Uid);
	List<searchbean> list = obj.getList1(Uid);
	//return back to index.jsp

	ModelAndView model = new ModelAndView("seemore");
	model.addObject("lists", list);

	return model;

     

}
@RequestMapping(value="/confirm",method=RequestMethod.GET)

public ModelAndView confirmfrnd(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
{
	 System.out.println("scontrollerconf");
	 
	HttpSession session1=request.getSession();
	session1.getAttribute("userid");
	int Uid=(Integer) session1.getAttribute("userid");
	 System.out.println("userid"+session1.getAttribute("userid"));
	 System.out.println("scontrollerconf");
	db_search obj= new db_search();
	obj.confirm(1,Uid,id,Uid);
	
	List<searchbean> list = obj.getList(Uid);
	//return back to index.jsp

	ModelAndView model = new ModelAndView("friendrequest");
	model.addObject("lists", list);

	return model;

  
}

@RequestMapping(value="/delete",method=RequestMethod.GET)

public ModelAndView deletefrnd(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
{
	 
	HttpSession session1=request.getSession();
	session1.getAttribute("userid");
	int Uid=(Integer) session1.getAttribute("userid");
	 System.out.println("userid"+session1.getAttribute("userid"));
	 System.out.println("id2:"+id);
	db_search obj= new db_search();
	obj.delete(0,id,id,Uid);
   
	List<searchbean> list = obj.getList(Uid);
	//return back to index.jsp

	ModelAndView model = new ModelAndView("friendrequest");
	model.addObject("lists", list);

	return model;

     
}
@RequestMapping(value="/unfriend",method=RequestMethod.GET)

public ModelAndView unfrnd(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
{
	 
	HttpSession session1=request.getSession();
	session1.getAttribute("userid");
	int Uid=(Integer) session1.getAttribute("userid");
	 System.out.println("userid"+session1.getAttribute("userid"));
	 System.out.println("id3:"+id);
	db_search obj= new db_search();
	obj.unfriend(0,Uid,id,Uid);
	
	List<searchbean> list = obj.getList(Uid);
	//return back to index.jsp

	ModelAndView model = new ModelAndView("searchfriend");
	model.addObject("lists", list);

	return model;

     

}
	@RequestMapping(value="/friendrequest",method=RequestMethod.GET)
public  ModelAndView request(searchbean sb, HttpSession session)
	{
		
			db_search objreq = new db_search();
			int Uid=(Integer) session.getAttribute("userid"); 

			List<searchbean> list = objreq.getList(Uid);
			//return back to index.jsp

			ModelAndView model = new ModelAndView("friendrequest");
			model.addObject("lists", list);

			return model;


			  }
		
	
	
	@RequestMapping(value="/searchfriend",method=RequestMethod.GET)

	
		public  ModelAndView search(searchbean sb,  HttpSession session)
		{
			
				db_search objsrch = new db_search();
				int Uid=(Integer) session.getAttribute("userid"); 
				List<searchbean> list = objsrch.getList2(Uid);
				//return back to index.jsp

				ModelAndView model = new ModelAndView("searchfriend");
				model.addObject("lists", list);

				return model;
	
	}
	@RequestMapping(value="/seemore",method=RequestMethod.GET)
	public  ModelAndView seemore(searchbean sb, HttpSession session)
	{
	
			db_search objsee = new db_search();
			int Uid=(Integer) session.getAttribute("userid"); 

			List<searchbean> list = objsee.getList1(Uid);
			//return back to index.jsp

			ModelAndView model = new ModelAndView("seemore");
			model.addObject("lists", list);

			return model;

}

}