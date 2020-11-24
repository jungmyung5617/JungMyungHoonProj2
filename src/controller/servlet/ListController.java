package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBSDao;
import model.BBSDto;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("id") == null) {
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<script>alert('회원만 이용가능합니다');location.href='/JungMyungHoonProj2/Home.jsp';</script>");
		
		out.flush();
		
		}
		else {
			BBSDao dao = new BBSDao(req.getServletContext());
			
			Map map = new HashMap();
			
			List<BBSDto> list = dao.selectList(map);
			 
			req.setAttribute("list", list);
			 
			req.getRequestDispatcher("/Project/List.jsp").forward(req, resp);}
	}////doGet

}////BBSController
