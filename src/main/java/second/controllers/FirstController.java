package second.controllers;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import second.business.EntriesBusinessInterface;
import second.business.UsersBusinessInterface;
import second.entites.Entries;
import second.entites.Users;



@Controller
public class FirstController {


	@Autowired
	@Qualifier("usersBusiness")
	private UsersBusinessInterface usersBusinessInterface;
	
	@Autowired
	@Qualifier("entriesBusiness")
	private EntriesBusinessInterface entriesBusiness;
	
	@Autowired
	public HttpSession session;

	@RequestMapping("/LoginPage")
	public ModelAndView login()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Login");
		return model;
	}

	@RequestMapping("/RegisterPage")
	public ModelAndView register()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Register");
		return model;
	}
	
	@RequestMapping(value="/Savedata",method = RequestMethod.POST)
	public ModelAndView savedata(@ModelAttribute("users") Users user)
	{
			usersBusinessInterface.save(user);
			ModelAndView model=new ModelAndView("savedata");
			return model;	
	}
	
	@RequestMapping(value="/Authentication",method=RequestMethod.POST)
	public ModelAndView authentication(@ModelAttribute("users") Users user1)
	{
		ModelAndView model=new ModelAndView("LoginIncorrect");

		Users user=null;
		
		user = usersBusinessInterface.findByName(user1.getUsername());
		if(user==null)
		{
			model.setViewName("LoginIncorrect");
			return model;
		}
			if(user!=null&&user1.getPassword().equals(user.getPassword()))
			{
				model.setViewName("Authentication");
				model.addObject("user",user);
				
				session.setAttribute("user", user);
				List<Entries> entries=entriesBusiness.findByUserId(user.getId());
	            entries.sort((entry1, entry2) -> entry2.getDate().compareTo(entry1.getDate()));
				model.addObject("entrieslist", entries);
			}
			return model;
	}
	
	@RequestMapping(value = "/Addentry")
	public ModelAndView addentry()
	{
		ModelAndView model=new ModelAndView("Addentry");
		
		return model;
	}
	
	@RequestMapping(value="/saveentry")
	public ModelAndView saveentry(@ModelAttribute("entries") Entries entry)
	{
		
		ModelAndView model=new ModelAndView("Authentication");
		Users user=(Users)session.getAttribute("user");
		if(user==null)
		{
			model.setViewName("LoginIncorrect");
			return model;
		}
		entriesBusiness.save(entry);
		
		List<Entries> entries=null;
		try {
			entries=entriesBusiness.findByUserId(user.getId());
            entries.sort((entry1, entry2) -> entry2.getDate().compareTo(entry1.getDate()));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		model.addObject("entrieslist",entries);
		
		
		return model;
	}
	
	@RequestMapping(value="/viewpage")
	public ModelAndView viewpage(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Viewpage");
		Entries entries=(Entries)entriesBusiness.get(id);
		model.addObject("entry", entries);
		return model;
	}
	
	@RequestMapping(value="/userpage")
	public ModelAndView userpage()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Authentication");
		
		Users user=(Users)session.getAttribute("user");
		if(user==null)
		{
			model.setViewName("LoginIncorrect");
			return model;
		}
		List<Entries> entries=null;
		try {
			entries=entriesBusiness.findByUserId(user.getId());
            entries.sort((entry1, entry2) -> entry2.getDate().compareTo(entry1.getDate()));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		
		return model;
	}
	
	@RequestMapping("/updatecontent")
	public ModelAndView updatecontent(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("updatecontent");
		
		Entries entry=entriesBusiness.get(id);
		model.addObject("entry",entry);
		
		return model;
	}
	
	@RequestMapping(value="/updateentry",method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("entries") Entries entry)
	{
		entriesBusiness.update(entry);
		ModelAndView model=new ModelAndView("Authentication");
		Users user=(Users)session.getAttribute("user");
		
		if(user==null)
		{
			model.setViewName("LoginIncorrect");
			return model;
		}
		List<Entries> entries=null;
		try {
			entries=entriesBusiness.findByUserId(user.getId());
            entries.sort((entry1, entry2) -> entry2.getDate().compareTo(entry1.getDate()));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		
		return model;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Authentication");
		
		Entries entry=entriesBusiness.get(id);
		entriesBusiness.delete(entry);
		
		Users user=(Users)session.getAttribute("user");
		
		if(user==null)
		{
			model.setViewName("LoginIncorrect");
			return model;
		}
		
		
		List<Entries> entries=null;
		try {
			entries=entriesBusiness.findByUserId(user.getId());
            entries.sort((entry1, entry2) -> entry2.getDate().compareTo(entry1.getDate()));
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("Login");
		session.invalidate();
		
		return model;
	}
	
}
