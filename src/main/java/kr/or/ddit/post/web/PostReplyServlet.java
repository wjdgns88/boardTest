package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class PostReplyServlet
 */
@WebServlet("/postReply")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class PostReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int post_id2 = Integer.parseInt(request.getParameter("post_id2"));
		int post_group = Integer.parseInt(request.getParameter("post_group"));
		title = new String(title.getBytes("8859_1"), "UTF-8");
		contents = new String(contents.getBytes("8859_1"), "UTF-8");
		PostServiceInf postService = new PostService();
		Collection<Part> parts = request.getParts();
		FileServiceInf fileService = new FileService();
		
		HttpSession session = request.getSession();
		StudentVo student = (StudentVo) session.getAttribute("userVo");
		int boardId = (int) session.getAttribute("boardId");
		PostVo postVo = new PostVo();
		postVo.setPost_id2(post_id2);
		postVo.setPost_group(post_group);
		postVo.setBoard_id(boardId);
		postVo.setPost_title(title);
		postVo.setPost_content(contents);
		postVo.setPost_dt(new Date());
		postVo.setId(student.getId());
		postVo.setPost_delet('1');
		
		postService.insertPostReply(postVo);
		
		for (Part part : parts) {
			if (part.getSize() > 0) {
				FileVo file = new FileVo();
				String contentDisposition = part.getHeader("content-Disposition");
				String pic = FileUtil.getFileName(contentDisposition);
				String picpath = FileUtil.fileUploadPath;
				String picname = UUID.randomUUID().toString();
				System.out.println(pic);
				if(pic != ""){
					file.setFile_name(picname);
					file.setFile_path(picpath);
					file.setFile_up(pic);
					
					part.write(picpath + File.separator + picname);
					part.delete();
					fileService.insertFile(file);
				}
			}
		}

		response.sendRedirect("/postList?page=1&pageSize=10&boardId="+boardId);
		
	}


}
