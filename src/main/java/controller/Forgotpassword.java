package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgotpassword")
public class Forgotpassword extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("password"));
		String password=req.getParameter("password");
		
		Stffdao staffdao=new Staffdao();
		
		
		Doctor doctor=staffdao.fetchDoctor(id);
		Stuff staff=staffdao.fetchStuff(id);
		j
		if(doctor==null&&staff==null) {
			resp.getwriter().print("<h1 style='color:red'>invalid id</h1>");
			req.getParameter("forgot.html").incude
		}
				
}	
}