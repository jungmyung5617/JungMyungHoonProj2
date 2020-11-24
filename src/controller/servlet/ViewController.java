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

public class ViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		BBSDao dao = new BBSDao(getServletContext());
		BBSDto dto = dao.selectOne(no);
		
		dao.close();
		
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/Project/View.jsp").forward(req, resp);
	}
	
	
}/////////ViewController
