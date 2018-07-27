package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String btn = request.getParameter("btn");
		PostServiceInf postService = new PostService();
		PostVo postVo = new PostVo();
		
		postVo = postService.selectPost(id);
		if(btn.equals("updata")){
			
			FileServiceInf fileService = new FileService();
			List<FileVo> fileVo = fileService.selectFile(id);
			System.out.println(fileVo);
			request.setAttribute("fileVo", fileVo);
			request.setAttribute("postVo", postVo);
			
			request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
		}else if(btn.equals("delete")){
			postVo.setPost_delet('0');
			postService.postdelete(postVo);
			
			request.getRequestDispatcher("/postList?page=1&pageSize=10&boardId="+postVo.getBoard_id()).forward(request, response);
		}else{
			request.setAttribute("postVo", postVo);
			request.getRequestDispatcher("/post/postReply.jsp").forward(request, response);
			
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("post_id"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.selectPost(id);
		
		postVo.setPost_id(id);
		postVo.setPost_title(title);
		postVo.setPost_content(contents);
		postVo.setPost_dt(new Date());
		
		postService.postUpdate(postVo);
		
		Collection<Part> parts = request.getParts();
		FileServiceInf fileService = new FileService();
		
		for (Part part : parts) {
			if (part.getSize() > 0) {
				FileVo file = new FileVo();
				String contentDisposition = part.getHeader("content-Disposition");
				String pic = FileUtil.getFileName(contentDisposition);
				String picpath = FileUtil.fileUploadPath;
				String picname = UUID.randomUUID().toString();
				System.out.println(pic);
				if(pic != ""){
					file.setPost_id(id);
					file.setFile_name(picname);
					file.setFile_path(picpath);
					file.setFile_up(pic);
					
					part.write(picpath + File.separator + picname);
					part.delete();
					fileService.updateFile(file);
				}
			}
		}
		
		response.sendRedirect("/postDetail?id="+id);
		
		
	}

}
