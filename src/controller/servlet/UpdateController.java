package controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBSDao;
import model.BBSDto;

public class UpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BBSDao dao = new BBSDao(getServletContext());
		req.getParameter("no");
		
		req.getRequestDispatcher("/Project/Update.jsp").forward(req, resp);
		
	}////doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BBSDao dao = new BBSDao(getServletContext());
		BBSDto dto = new BBSDto();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		int affect = dao.update(dto);
		
		if(affect==1) {
			Map map = new HashMap();
			
			List<BBSDto> list = dao.selectList(map);
			 
			req.setAttribute("list", list);
			 
			req.getRequestDispatcher("/Project/List.jsp").forward(req, resp);
		}
		else {
			System.out.println("에러");
		}
	}////doPost

}/////////UpdateControwller
