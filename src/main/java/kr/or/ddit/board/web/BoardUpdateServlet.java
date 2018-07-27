package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String click = request.getParameter("button");
		if(click.equals("insert")){
			String upName = request.getParameter("boardName");
			String delete = request.getParameter("select");
			if(upName != ""){
				upName = new String(upName.getBytes("8859_1"),"UTF-8");
				HttpSession session = request.getSession();
				StudentVo studentVo = (StudentVo) session.getAttribute("userVo");
				
				BoardServiceInf boardService = new BoardService();
				BoardVo board = new BoardVo();
				board.setBoard_name(upName);
				board.setBoard_dt(new Date());
				board.setId(studentVo.getId());
				board.setBoard_delet(delete.charAt(0));		// 옵션값 가져와서 넣어야됨
				
				boardService.insertBoard(board);
			}
		}else{
			String upName = request.getParameter("upboardName");
			upName = new String(upName.getBytes("8859_1"),"UTF-8");
			String delete = request.getParameter("select");
			HttpSession session = request.getSession();
			StudentVo studentVo = (StudentVo) session.getAttribute("userVo");
			String boardnum = request.getParameter("boardnum");
			int boardId = Integer.parseInt(boardnum);
			
			BoardServiceInf boardService = new BoardService();
			BoardVo board = new BoardVo();
			board.setBoard_id(boardId);
			board.setBoard_name(upName);
			board.setId(studentVo.getId());
			board.setBoard_dt(new Date());
			board.setBoard_delet(delete.charAt(0));
			
			boardService.boardUpdate(board);
		}
			
		response.sendRedirect("/boardList");
		
	}


}
