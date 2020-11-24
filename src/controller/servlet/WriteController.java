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
import javax.servlet.http.HttpSession;

import model.MemberDao;
import model.BBSDao;
import model.BBSDto;

public class WriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/Project/Write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String title =req.getParameter("title");
		String content = req.getParameter("content");
		
		HttpSession session = req.getSession();
		
		String id = session.getAttribute("id").toString();
		
		BBSDto dto = new BBSDto(null,id,title,content,null,null);
		BBSDao dao = new BBSDao(getServletContext());

		int affected = dao.insert(dto);
		
		Map map = new HashMap();
		List<BBSDto> list = dao.selectList(map);
		req.setAttribute("list", list);
		
		dao.close();
		if(affected == 1){
			req.getRequestDispatcher("List.jsp").forward(req, resp);
		}
		else{
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			
			out.println("<script>alert('입력실패 했습니다');location.href='/JungMyungHoonProj2/Project/List.jsp';</script>");
			
			out.flush();
			
		}
		
	}///doPost
}
