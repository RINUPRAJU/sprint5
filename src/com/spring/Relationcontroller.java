package com.spring;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pkgdbconnection.db_relationship;
import pkgdbconnection.db_search;

import com.bean.searchbean;


public class Relationcontroller {

	@RequestMapping(value="/confirm",method=RequestMethod.GET)

	public ModelAndView confirmfrnd(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
//		 System.out.println("scontrollerconf");
		 
		HttpSession session1=request.getSession();
		session1.getAttribute("userid");
		int Uid=(Integer) session1.getAttribute("userid");
		/* System.out.println("userid"+session1.getAttribute("userid"));
		 System.out.println("scontrollerconf");*/
		db_relationship obj= new db_relationship();
//		obj.confirm(1,Uid,id,Uid);
		
		//List<searchbean> list = obj.getList();
		//return back to index.jsp

		ModelAndView model = new ModelAndView("friendrequest");
		//model.addObject("lists", list);

		return model;

	}
	@RequestMapping(value="/unfriend",method=RequestMethod.GET)

	public ModelAndView unfrnd(@RequestParam ("id")Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		 
		HttpSession session1=request.getSession();
		session1.getAttribute("userid");
		int Uid=(Integer) session1.getAttribute("userid");
		 /*System.out.println("userid"+session1.getAttribute("userid"));
		 System.out.println("id2"+id);*/
		db_search obj= new db_search();
		obj.unfriend(0,Uid,id,Uid);
		
		//List<searchbean> list = obj.getList();
		//return back to index.jsp

		ModelAndView model = new ModelAndView("searchfriend");
		//model.addObject("lists", list);

		return model;
	}
	@RequestMapping(value="/friendrequest",method=RequestMethod.GET)
	public  ModelAndView request(searchbean sb)
		{
			
				db_search objreq = new db_search();

				List<searchbean> list = objreq.getList(0);
				//return back to index.jsp

				ModelAndView model = new ModelAndView("friendrequest");
				model.addObject("lists", list);

				return model;


				  }
			
		
		
		@RequestMapping(value="/searchfriend",method=RequestMethod.GET)

		
			/*public  ModelAndView search(searchbean sb)
			{
				
					//db_search objsrch = new db_search();

					//List<searchbean> list = objsrch.getList();
					//return back to index.jsp

					//ModelAndView model = new ModelAndView("searchfriend");
					//model.addObject("lists", list);

            		//return model;
		
					@RequestMapping(value="/friendrequest",method=RequestMethod.GET)
					public  ModelAndView requesting(searchbean sb)
						{
							
								db_search objreq = new db_search();

								//List<searchbean> list = objreq.getList();
								//return back to index.jsp

								ModelAndView model = new ModelAndView("friendrequest");
								//model.addObject("lists", list);

								return model;


								  }
							
						
						
						@RequestMapping(value="/searchfriend",method=RequestMethod.GET)*/

						
							public  ModelAndView searching(searchbean sb)
							{
								
									db_search objsrch = new db_search();

									//List<searchbean> list = objsrch.getList();
									//return back to index.jsp

									ModelAndView model = new ModelAndView("searchfriend");
									//model.addObject("lists", list);

									return model;
						
						}	     
}