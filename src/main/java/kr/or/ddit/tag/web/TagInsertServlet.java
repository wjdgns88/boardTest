package kr.or.ddit.tag.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.tag.model.TagVo;
import kr.or.ddit.tag.service.TagService;
import kr.or.ddit.tag.service.TagServiceInf;

/**
 * Servlet implementation class TagInsertServlet
 */
@WebServlet("/tagInsert")
public class TagInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PostVo postVo = (PostVo) session.getAttribute("postVo");
		String delete = request.getParameter("delete");
		if(delete != null){
			int tag = Integer.parseInt(request.getParameter("tagnum"));
			TagServiceInf tagService = new TagService();
			tagService.deleteTag(tag);
			
		}else{
			String tagContent = request.getParameter("tag");
	
			TagServiceInf tagService = new TagService();
			StudentVo studentVo = (StudentVo) session.getAttribute("userVo");
	
			if (tagContent != null) {
				tagContent = new String(tagContent.getBytes("8859_1"), "UTF-8");
				TagVo tag = new TagVo();
				tag.setTag_content(tagContent);
				tag.setTag_dt(new Date());
				tag.setId(studentVo.getId());
				tag.setPost_id(postVo.getPost_id());
				tag.setTag_delet('1');
	
				tagService.insertTag(tag);
			}
		}
		
		response.sendRedirect("/postDetail?id="+postVo.getPost_id());
	}

}
