package kr.or.ddit.file.model;

public class FileVo {
	
	private int file_id;
	private int post_id;
	private String file_up;
	private String file_path;
	private String file_name;
	
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getFile_up() {
		return file_up;
	}
	public void setFile_up(String file_up) {
		this.file_up = file_up;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	@Override
	public String toString() {
		return "FileVo [file_id=" + file_id + ", post_id=" + post_id
				+ ", file_up=" + file_up + ", file_path=" + file_path
				+ ", file_name=" + file_name + "]";
	}
	
	
	
}
