package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	
	private int post_id;
	private int board_id;
	private int post_id2;
	private int id;
	private int post_group;
	private String post_title;
	private String post_content;
	private Date post_dt;
	private char post_delet;
	
	public PostVo() {
		
	}
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getPost_id2() {
		return post_id2;
	}
	public void setPost_id2(int post_id2) {
		this.post_id2 = post_id2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_group() {
		return post_group;
	}
	public void setPost_group(int post_group) {
		this.post_group = post_group;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_dt() {
		return post_dt;
	}
	public void setPost_dt(Date post_dt) {
		this.post_dt = post_dt;
	}
	public char getPost_delet() {
		return post_delet;
	}
	public void setPost_delet(char post_delet) {
		this.post_delet = post_delet;
	}
	@Override
	public String toString() {
		return "PostVo [post_id=" + post_id + ", board_id=" + board_id
				+ ", post_id2=" + post_id2 + ", id=" + id + ", post_group="
				+ post_group + ", post_title=" + post_title + ", post_content="
				+ post_content + ", post_dt=" + post_dt + ", post_delet="
				+ post_delet + "]";
	}
	
	
}
