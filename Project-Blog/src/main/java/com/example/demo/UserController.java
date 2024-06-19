package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	
	@Autowired
	private JdbcTemplate db;
	
	BCryptPasswordEncoder c = new BCryptPasswordEncoder();
	
	@GetMapping("Login")
	public String getlogin() {
		
		return "Login.jsp";
		
	}
	

	public boolean isValid(String email, String pass) {
		try {
			
			String sql="select Password from users where Email=?";
			
			@SuppressWarnings("deprecation")
			String decoded = db.queryForObject(sql, new Object[] {email}, String.class);
			
			return c.matches(pass, decoded);
			
		}catch(Exception e) {
			
			return false;
			
		}
	}
	
	
	
	@SuppressWarnings("deprecation")
	@PostMapping("Login")
	public String login(Model model, @RequestParam("email") String email, @RequestParam("pass") String pass, HttpServletRequest req) {
		
		if(email.equals("Admin@123") && pass.equals("admin")) {
			req.getSession().setAttribute("email", email);
			UserObj o=new UserObj("ADMIN");
			BlogController.admin = true;
			return "redirect:/Blogs";
			
		}
		else
		try {
		
		@SuppressWarnings("unused")
		UserObj rc = db.queryForObject("select name from users where Email = ?", 
				new Object[] {email},
				(rs, rowNum) -> new UserObj(
						rs.getString(1)
					)
		);
		
		
		
		if(isValid(email, pass)) {
			req.getSession().setAttribute("email", email);
			return "redirect:/Blogs";
		}else {
			model.addAttribute("cl", "danger");
			model.addAttribute("log", "Invalid Email and Password");
			return "Login.jsp";
		}
	
	}catch(Exception e) {
		model.addAttribute("cl", "danger");
		model.addAttribute("log", "Invalid Email and Password");
		return "Login.jsp";
		
		}
	}
	
	@GetMapping("Register")
	public String getRegister() {
		return "Register.jsp";
	}
	
	
	@PostMapping("Register")
	public String Register(Model model, @RequestParam("name") String nam, @RequestParam("email") String email, @RequestParam("pass") String pass, @RequestParam("phno") String phno, HttpServletRequest req) {
		
		String name=nam.toUpperCase();
		
		String sql="Select count(*) from users where Email=?";
		int isUserExist =  db.queryForObject(sql, Integer.class, email);
		if(isUserExist>0) {
			model.addAttribute("reg", "Email Already in Use");
		
			return "Register.jsp";
			
		}else {
		
		String encoded=c.encode(pass);
		sql="insert into users (Name, Email, Password, Phno) values (?,?,?,?)";
		int s=db.update(sql, name, email, encoded, phno);
		if(s!=0) {
			
			req.getSession().setAttribute("email", email);
			
			@SuppressWarnings("unused")
			UserObj o=new UserObj(name);
			
			
			return "redirect:/Blogs";
			
		}else
			return "error";
		}
	}
	
	@GetMapping("Logout")
	public String logout(HttpServletRequest req) {
		HttpSession s=req.getSession(false);
		if(req.getSession().getAttribute("email")!=null) {
			s.invalidate();
			BlogController.admin = false;
		return "/";
		}else {
			return "Login";
		}
	}
	@GetMapping("Forgot")
	public String forg() {
		return "Forgot.jsp";
	}
	
	@PostMapping("Forgot")
	public String forgot(Model model, @RequestParam("email") String email, @RequestParam("phno") String phno, @RequestParam("npass") String npass, @RequestParam("cpass") String cpass) {
		String er="";
		
		if(!cpass.equals(npass))
				er+=" |Both Passwords Not Matching| ";
		else {
			String encoded=c.encode(npass);
			String sql="update users set Password=? where Email=? and Phno=?";
			int s=db.update(sql, encoded, email, phno);
			if(s>0) {
				model.addAttribute("log", "Password Changed Succesfully..");
				model.addAttribute("cl", "success");
				return "Login.jsp";
			}else {
				//model.addAttribute("cl", "danger");
			er+=" |Invalid Email and Phone Number|";
			}
		
	}
		model.addAttribute("frg", er);
		return "Forgot.jsp";
	}
	
	
}
