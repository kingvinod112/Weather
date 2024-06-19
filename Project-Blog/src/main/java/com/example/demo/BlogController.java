package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller()
public class BlogController {
	
	public static boolean admin = false;
	
	
	@Autowired
	private JdbcTemplate db;
	int n=0,d=0,u=0;
	//-----------------------------------------------	HOME   ----------------------------------------------------------
	@GetMapping("/")
	public  String home(HttpServletRequest req) {
		if(req.getSession().getAttribute("email")==null) {
			req.setAttribute("hlo", "Login");
			req.setAttribute("colr", "info");
			req.setAttribute("username", "Please Login..");
			
		}else {
			req.setAttribute("hlo", "Logout");
			req.setAttribute("colr", "danger");
		req.setAttribute("username", "Welcome "+UserObj.getName());
		
		}return "Home.jsp";
		
	}
	
//-------------------------------------------------  BLOGS ---------------------------------------------------------------
	
	@GetMapping("Blogs")
	public String blog(HttpServletRequest req,Model model) {

		if(req.getSession().getAttribute("email")==null) {
			req.setAttribute("hlo", "Login");
			req.setAttribute("colr", "info");
			req.setAttribute("username", "Please Login..");
		}else {
			req.setAttribute("hlo", "Logout");
			req.setAttribute("colr", "danger");
			model.addAttribute("username", "Welcome "+UserObj.getName());
		}
		
		
		String sql="select * from Blog Order by id desc";
		
		List<Blog> records=db.query(sql,
				(rs, rowNum) -> new Blog( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		model.addAttribute("records", records);
		if(n>0) {
			model.addAttribute("nblg", "New Blog Added");
			model.addAttribute("mc", "success");
			n=0;
			}
		if(records.isEmpty()) {
			model.addAttribute("myblg", "No Blogs Yet Create Blog..");
			model.addAttribute("myc", "secondary");
		}
		
		if(admin) {
			model.addAttribute("del", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"30\" height=\"38\" fill=\"currentColor\" class=\"bi bi-trash\" viewBox=\"0 0 16 16\">\r\n"
					+ "  <path d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z\"/>\r\n"
					+ "  <path d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z\"/>\r\n"
					+ "</svg>");
			model.addAttribute("edt", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"30\" height=\"38\" fill=\"currentColor\" class=\"bi bi-pencil-square\" viewBox=\"0 0 16 16\">\r\n"
					+ "  <path d=\"M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z\"/>\r\n"
					+ "  <path fill-rule=\"evenodd\" d=\"M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z\"/>\r\n"
					+ "</svg>");
		}
		
		return "Blogs.jsp";
		
		
	}

	//---------------------------------------------- USER BLOGS --------------------------------------------------------------
	
	@GetMapping("MyBlog")
	public String myblog(HttpServletRequest req,Model model) {
		

		if(req.getSession().getAttribute("email")==null) {
			
			req.setAttribute("cl", "info");
			req.setAttribute("log", "Login to See Blogs");
			
			return "Login.jsp";
		}else {
			req.setAttribute("hlo", "Logout");
			req.setAttribute("colr", "danger");
			model.addAttribute("username", "Welcome "+UserObj.getName());
		
		
		
		String sql="select * from Blog where name=? order by id desc";
		
		@SuppressWarnings("deprecation")
		List<Blog> records=db.query(sql, new String[] {UserObj.getName()}, 
				(rs, rowNum) -> new Blog(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		model.addAttribute("records", records);
		if(records.isEmpty()) {
			model.addAttribute("myblg", "You Have no Blogs. Create a Blog");
			model.addAttribute("myc", "danger");
		}
			
		else {
			model.addAttribute("myblg", "Your Blogs");
			model.addAttribute("myc", "success");
		}
		
		model.addAttribute("del", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"30\" height=\"38\" fill=\"currentColor\" class=\"bi bi-trash\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z\"/>\r\n"
				+ "  <path d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z\"/>\r\n"
				+ "</svg>");
		model.addAttribute("edt", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"30\" height=\"38\" fill=\"currentColor\" class=\"bi bi-pencil-square\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path d=\"M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z\"/>\r\n"
				+ "  <path fill-rule=\"evenodd\" d=\"M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z\"/>\r\n"
				+ "</svg>");
		
		model.addAttribute("username", "Welcome "+UserObj.getName());
		if(u>0) {
			model.addAttribute("nblg", "Blog Updated");
			model.addAttribute("mc", "info");
			u=0;
			}
		if(d>0) {
			model.addAttribute("nblg", "Blog Deleted");
			model.addAttribute("mc", "danger");
			d=0;
			}
		return "Blogs.jsp";
		
		
	}
	}
	
	//---------------------------------------------- CREATE BLOG -----------------------------------------------------------
	@GetMapping("Create")
	public String crete(HttpServletRequest req, Model model) {
		
		if(req.getSession().getAttribute("email")==null) {
			
			req.setAttribute("cl", "info");
			req.setAttribute("log", "Login to Create Blog");
			
			return "Login.jsp";
		}else {
			if(admin) 
				model.addAttribute("upd", "text");
				
			else
				model.addAttribute("upd", "hidden");
			
			model.addAttribute("aname", UserObj.getName());
			return "Create.jsp";
		}
		
	}
	
	@PostMapping("Create")
	public String create(HttpServletRequest req, Model model,@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("aname") String name) {
		if(req.getSession().getAttribute("email")!=null) {
		String sql="insert into Blog (Name, Title, Content) values (?,?,?)";
		n=db.update(sql, name, title, content);
		}
		return "redirect:/Blogs";
		
	}
	//----------------------------------------------- UPDATE  ----------------------------------------------------------------
	
	@GetMapping("Edit")
	public String edt(Model model, @RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("cont") String cont, @RequestParam("aname") String name) {
		model.addAttribute("uid",id);
		model.addAttribute("utitle",title);
		model.addAttribute("ucont",cont);
		model.addAttribute("uname", name);
		
		if(admin) 
			model.addAttribute("upd", "text");
		else
			model.addAttribute("upd", "hidden");
		
		return "Update.jsp";
	}
	
	@PostMapping("Edit")
	public String edit(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("cont") String cont, @RequestParam("aname") String name) {
		if(req.getSession().getAttribute("email")!=null) {
		String sql="update Blog set title=?, content=?, Name=? where id=?";
		 u=db.update(sql, title, cont, name, id);
		}
		 if(admin) 
			 return "redirect:/Blogs";
			else
		return "redirect:/MyBlog";
	}
	
	
	//-----------------------------------------------  DELETE  ---------------------------------------------------------------
	@GetMapping("Delete")
	public String del(HttpServletRequest req, @RequestParam("id") String id) {
		
		if(req.getSession().getAttribute("email")!=null) {
		String sql="delete from Blog where Id=?";
		d=db.update(sql, id);
		}
		if(admin) 
			 return "redirect:/Blogs";
		else
			return "redirect:/MyBlog";
	}
	
	
	
	//-----------------------------------------------  SEARCH  --------------------------------------------------------------
	@PostMapping("Search")
	public String Search(HttpServletRequest req, @RequestParam("srch") String value) {
		if(req.getSession().getAttribute("email")==null) {
			req.setAttribute("hlo", "Login");
			req.setAttribute("colr", "info");
			req.setAttribute("username", "Please Login..");
		}else {
			req.setAttribute("hlo", "Logout");
			req.setAttribute("colr", "danger");
			req.setAttribute("username", "Welcome "+UserObj.getName());
		}
		
		@SuppressWarnings("deprecation")
		List<Blog> records = db.query(
				"select * from Blog where Title like ?", 
				new String[] {"%" + value + "%"},
				(rs, rowNum) -> new Blog(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				)				
		);
		req.setAttribute("records", records);
		if(records.isEmpty()) {
			req.setAttribute("myblg", "No Blogs Found !");
			req.setAttribute("myc", "secondary");
		}
		
		return "Blogs.jsp";
	}

}
