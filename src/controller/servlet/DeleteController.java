package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBSDao;

public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		System.out.println(no);
		BBSDao dao = new BBSDao(getServletContext());
		dao.delete(no);
		dao.close();
		//resp.sendRedirect("/Project/List.kosmo");
		req.getRequestDispatcher("/Project/List.kosmo").forward(req, resp);
	}////doGet
}/////////DeleteController
