package com.spring;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pkgdbconnection.DBinsert;

import com.bean.Registerbean;


@Controller
public class hellocontroller 
{
	public String saveDirectory= "C:/Users/user/workspace/Myspring/WebContent/WEB-INF/images";
@RequestMapping(value="/",method=RequestMethod.GET)
public String init(Model model)
{
	
	return "index";
}

@RequestMapping(value="/reg",method=RequestMethod.POST)
public String submit(Model model,@ModelAttribute("registerbean") Registerbean registerbean)
		//,HttpServletRequest request,BindingResult Result,@RequestParam CommonsMultipartFile file) throws SQLException

{
String fname =registerbean.getFirstname();
System.out.println(fname);
return null;

}

@RequestMapping(value="/create",method=RequestMethod.POST)
//public String create(Model model,@ModelAttribute("registerbean") Registerbean registerbean,HttpServletRequest request,BindingResult Result,@RequestParam CommonsMultipartFile file) throws SQLException
public String create(Model model,HttpServletRequest request,@ModelAttribute("registerbean") Registerbean registerbean,BindingResult Result,@RequestParam CommonsMultipartFile file) throws SQLException
{
	
	String fname =registerbean.getFirstname();
	System.out.println(fname);

	DBinsert obj =new DBinsert();
	String dob=registerbean.getYear()+"/"+registerbean.getMonth()+"/"+registerbean.getDay();
	String filename=file.getOriginalFilename();
	String fileupload=filename + registerbean.getEmail();
	System.out.println("fileupload"+fileupload);
	try{
		byte barr[]=file.getBytes();
		BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(saveDirectory+"/"+fileupload));
		bout.write(barr);
		bout.flush();
		bout.close();
		}
	catch(Exception e ){System.out.println(e);}
	String result =obj.insert(registerbean.getFirstname(),registerbean.getLastname(),registerbean.getEmail(), registerbean.getReemail(), registerbean.getPassword(),fileupload,dob,registerbean.getGender());
 
	
		
		
		HttpSession session1=request.getSession();
		session1.setAttribute("firstname", registerbean.getFirstname());
		session1.setAttribute("lastname", registerbean.getLastname());
		session1.setAttribute("file",fileupload);
		
		
		
		
		return "home";
	
	
}

	


}
