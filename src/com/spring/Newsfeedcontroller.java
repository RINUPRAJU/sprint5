package com.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pkgdbconnection.DBinsert;
import pkgdbconnection.Db_newsfeed;

import com.bean.newsfeedbean;

@Controller
public class Newsfeedcontroller {
	@RequestMapping(value="/newspost",method=RequestMethod.POST)
	public ModelAndView post(Model model,HttpSession session, HttpServletRequest request,@ModelAttribute("newsfeedbean") newsfeedbean newsfeed) throws SQLException
	{
	 String nfstatus=newsfeed.getNewsstatus();
	System.out.println(nfstatus);
	System.out.println("status:"+newsfeed.getNewsstatus());
	int nw_Uid=(Integer) session.getAttribute("userid");
	System.out.println("THE ID;"+nw_Uid);
	

	  HttpSession session1=request.getSession();
	  session1.getAttribute("userid");
	  
	  
	  Db_newsfeed obj=new Db_newsfeed();
	  obj.newsinsert(nw_Uid,newsfeed.getNewsstatus());
	  List<newsfeedbean>list=obj.getList();

	  ModelAndView model1 = new ModelAndView("home");
	  model1.addObject("lists",list);
	  
	  return model1  ;
	}

     @RequestMapping(value="/imguploading", method=RequestMethod.POST)
	public ModelAndView  nwfdstatus(ModelAndView model,HttpServletRequest request,@ModelAttribute("newsfeedbean")newsfeedbean newsfeed,@RequestParam CommonsMultipartFile[]images) throws SQLException
	{
    	  String saveDirectory= "C:/Users/user/workspace/Myspring/WebContent/WEB-INF/images";
    	  Db_newsfeed objnimg=new Db_newsfeed();
	      HttpSession session1=request.getSession();
		  session1.getAttribute("userid");
		  int log_Uid=(Integer) session1.getAttribute("userid");
		  String fileName=null;
		  String msg="";
		 if(images != null && images.length>0){
			 for(int i =0;i< images.length;i++){
				 try{
					 fileName=images[i].getOriginalFilename();
					 byte[]bytes=images[i].getBytes();
					 BufferedOutputStream buffStream=
							 new BufferedOutputStream(new FileOutputStream(new File(saveDirectory+"/"+fileName)));
					 buffStream.write(bytes);
					 buffStream.close();
					 objnimg.imginsert(log_Uid, newsfeed.getImgstatus(),fileName);
					 List<newsfeedbean>list=objnimg.getList1();
					 ModelAndView model1 = new ModelAndView("home");
					  model1.addObject("lists",list);

					  
					 msg+="You have successfully uploaded"+fileName+"<br/>";
				 }catch (Exception e){
					 return model;
				 }
			 }
			 return model;
		 }else {
			 return model;
		 }
		  
		 // System.out.println("imgupload1:"+newsfeed.getImgupload());
		 
		 // obj.newsinsert(nw_Uid,newsfeed.getNewsstatus());
          /*String nimgstatus=newsfeed.getImgstatus();
	      System.out.println("imgstatus1:"+nimgstatus);
          */

		 
	}

}
