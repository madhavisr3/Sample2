package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Stuff;
@WebServlet("/login")
public class Login extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
String password =req.getParameter("password");

Staffdao staffdao=new Staffdao();
doctor doctor=staffdao.fetchDoctor(id);


if(staff==null&&doctor==null&&id!=99999999) {
	resp.getWriter().print("<h1 style='color:red'>Incorrectid</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	
}
else {
	if(staff!=null) {
		if(staff.getPassword().equals(password)) {
		resp.getWriter().print("<h1 style='color:green'>loginsucess</h1>");
		req.getRequestDispatcher("staffhome.html").include(req, resp);
			
	}
		else {
			resp.getWriter().print("<h1 style='color:red'>Incorrec password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
		if(doctor!=null) {
			if(doctor.getpassword().equals(password)){
				resp.getWriter().print("<h1 style='color:green'>login sucess</h1>");
				req.getRequestDispatcher("doctorhome.html").include(req, resp);
					
			}
			else {
				resp.getWriter().print("<h1 style='color:red'>incorrect password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
				
			
			}
		}
		if(id==999999)
		{
			if("999999".equals(password)) {
				resp.getWriter().print("<h1 style='color:green'>login suceess</h1>");
          				req.getRequestDispatcher("adminhome.html").include(req, resp);
				
			}
			else {
				resp.getWriter().print("<h1 style='color:red'>Incorrec pasword</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
				
			}
	
		}
		
}}
}
}

