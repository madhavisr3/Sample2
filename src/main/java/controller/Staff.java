package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Staffdao;
import dto.Stuff;

@WebServlet("/staffsignup")
public class Staff extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String password = req.getParameter("pasword");
//		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Staffdao staffdao = new Staffdao();
		if (staffdao.fetchByMobile(mobile) == null && staffdao.FetchByEmail(email) == null) {

			Stuff staff = new Stuff();
			staff.setName(name);
			staff.setMobile(mobile);
			staff.setGender(gender);
			staff.setDob(dob);
			staff.setPassword(password);
			staff.setEmail(email);

			staffdao.save(staff);
			resp.getWriter().print("<h1 style='color:green'>Stuff account created sucessully</h1>");
			resp.getWriter().print("<h1 style='color:blue'>" + staff.getId() + "</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1 style='colour:red'>mobile number or email is alredy exist ");
			req.getRequestDispatcher("staffsignup.html").include(req, resp);
		}
	}
}