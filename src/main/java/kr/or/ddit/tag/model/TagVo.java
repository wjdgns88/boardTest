package kr.or.ddit.tag.model;

import java.util.Date;

public class TagVo {

	private int tag_id;
	private String tag_content;
	private Date tag_dt;
	private int id;
	private int post_id;
	private char tag_delet;
	
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_content() {
		return tag_content;
	}
	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}
	public Date getTag_dt() {
		return tag_dt;
	}
	public void setTag_dt(Date tag_dt) {
		this.tag_dt = tag_dt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public char getTag_delet() {
		return tag_delet;
	}
	public void setTag_delet(char tag_delet) {
		this.tag_delet = tag_delet;
	}
	@Override
	public String toString() {
		return "TagVo [tag_id=" + tag_id + ", tag_content=" + tag_content
				+ ", tag_dt=" + tag_dt + ", id=" + id + ", post_id=" + post_id
				+ ", tag_delet=" + tag_delet + "]";
	}
	
	
	
	
	

	
	
	
	
}
