package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/postList")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		String boardIdStr = request.getParameter("boardId");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);
		int boardId = boardIdStr == null ? 1 : Integer.parseInt(boardIdStr);
		HttpSession session = request.getSession();
		session.setAttribute("boardId", boardId);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",  page);
		map.put("pageSize", pageSize);
		map.put("boardId", boardId);
		
		PostServiceInf postService = new PostService();
		Map<String, Object> resultMap = postService.getPostPageList(map);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("pageList");
		request.setAttribute("postList", postList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/postList.jsp");
		rd.forward(request, response);
		
		
	}


}
