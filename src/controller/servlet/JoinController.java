package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;

public class JoinController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/Project/Join.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
		String gender = req.getParameter("gender");
		String grade = req.getParameter("grade");
		
		MemberDao dao = new MemberDao(req.getServletContext());
		
		dao.insert(id, pwd, name, age, address, email, phoneNumber, gender, grade);
		
		dao.close();
		
		resp.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = resp.getWriter();
		 
		out.println("<script>alert('회원가입을 축하드립니다. 로그인 후 이용해주세요');location.href='/JungMyungHoonProj2/Home.jsp';</script>");
		
		out.flush();
	}/////doPost
}/////JoinController
