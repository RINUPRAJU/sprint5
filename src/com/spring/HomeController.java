package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pkgdbconnection.DBinsert;
import pkgdbconnection.Db_newsfeed;

import com.bean.LoginBean;
import com.bean.newsfeedbean;

@Controller
public class HomeController {
	
	  
	  	
	@RequestMapping(value="/login",method=RequestMethod.POST)

	public ModelAndView submit(HttpSession session,Model model,HttpServletRequest request,HttpServletResponse response, @ModelAttribute("loginbean") LoginBean loginbean) throws SQLException

	{
	String uname =loginbean.getUsername();
	System.out.println("uname"+uname);

	DBinsert obj =new DBinsert();


	ResultSet y=obj.select(loginbean.getUsername(),loginbean.getPassword());
    ResultSet y1=obj.emailerror(loginbean.getUsername());
    System.out.println(y1);
	System.out.println("register="+y);
	if(y.next())
	{
		if((loginbean.getUsername().equals(y.getString("Email")))&&(loginbean.getPassword().equals(y.getString("Password"))))
			
		{
			/* model.addAttribute("firstname",y.getString("Firstname"));
			    model.addAttribute("lastname",y.getString("Lastname"));*/
			HttpSession session1=request.getSession();
			session.setAttribute("userid", y.getInt("ID"));
			session1.setAttribute("firstname", y.getString("Firstname"));
			session1.setAttribute("lastname", y.getString("Lastname"));
			session1.setAttribute("file",y.getString("file"));
			

			 Db_newsfeed obj1=new Db_newsfeed();
			//int nw_Uid=(Integer) session.getAttribute("userid");
			List<newsfeedbean>list=obj1.getList();

			  ModelAndView model1 = new ModelAndView("home");
			  model1.addObject("lists",list);
			  
			  return model1  ;
			  
			 
			
			}
	
		 Db_newsfeed nwimg=new Db_newsfeed();
			//int nw_Uid=(Integer) session.getAttribute("userid");
			List<newsfeedbean>list1=nwimg.getList();

			  ModelAndView model1 = new ModelAndView("home");
			  model1.addObject("lists",list1);
			  
			  return model1  ;
		  
	}
	
	
		 if(y1.next())
			{
				if((loginbean.getUsername().equals(y1.getString("Email"))))
						{
					System.out.println("username");
					model.addAttribute("firstname",y1.getString("Firstname"));
					model.addAttribute("lastname",y1.getString("Lastname"));
					model.addAttribute("username",loginbean.getUsername());
					ModelAndView model1=new ModelAndView("pswdincrct");
					return model1;
						}
	}
	
		 else
		 {
	
    ModelAndView model1=new ModelAndView("emailincrct");
	return model1;
	}
	return null;
	}
	
//	@RequestMapping(value="/file")
//	{
//		return "home";
//	}
//	
	
@RequestMapping(value="/logout")
 public String logout(HttpServletRequest request){
	HttpSession httpSession=request.getSession();
	httpSession.invalidate();
		return "index";
	}
		
	}

