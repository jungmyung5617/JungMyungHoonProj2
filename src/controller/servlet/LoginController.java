package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/Project/Login.jsp");
	}////doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		MemberDao dao = new MemberDao(req.getServletContext());
		
		boolean flag = dao.isMember(id, pwd);
		if(flag) {
		HttpSession session = req.getSession();
		
		session.setAttribute("id", id);
		
		dao.close();
		
		resp.sendRedirect(req.getContextPath()+"/Home.jsp");
		}
		else {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			
			out.println("<script>alert('아이디와 비밀번호를 확인해주세요');location.href='/JungMyungHoonProj2/Home.jsp';</script>");
			
			out.flush();
			
		}
	}////doPost
	
}/////LoginController
