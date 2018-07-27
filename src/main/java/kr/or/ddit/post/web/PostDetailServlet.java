package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;
import kr.or.ddit.tag.model.TagVo;
import kr.or.ddit.tag.service.TagService;
import kr.or.ddit.tag.service.TagServiceInf;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.selectPost(id);
		
		FileServiceInf fileService = new FileService();
		List<FileVo> fileList = fileService.selectFile(postVo.getPost_id());
		TagServiceInf tagService = new TagService();
		List<TagVo> tagList = tagService.selectTag(postVo.getPost_id());
		StudentServiceInf studentService = new StudentService();
		List<StudentVo> student = studentService.selectAllStudents();
		request.setAttribute("student", student);
		request.setAttribute("tagList", tagList);
		
		HttpSession session = request.getSession();
		session.setAttribute("postVo", postVo);
		session.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
		
	
	

}
