package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private int board_id;
	private String board_name;
	private char board_delet;
	private int id;
	private Date board_dt;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public char getBoard_delet() {
		return board_delet;
	}
	public void setBoard_delet(char board_delet) {
		this.board_delet = board_delet;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", board_name=" + board_name
				+ ", board_delet=" + board_delet + ", id=" + id + ", board_dt="
				+ board_dt + "]";
	}
	
	
	
	
}
