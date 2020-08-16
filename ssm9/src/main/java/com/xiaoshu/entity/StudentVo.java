package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentVo extends Student{

	private String cname;
	
	private Integer num;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entrytime1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entrytime2;
	public String getCname() {
		return cname;
	}
	public Integer getNum() {
		return num;
	}
	public Date getEntrytime1() {
		return entrytime1;
	}
	public Date getEntrytime2() {
		return entrytime2;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setEntrytime1(Date entrytime1) {
		this.entrytime1 = entrytime1;
	}
	public void setEntrytime2(Date entrytime2) {
		this.entrytime2 = entrytime2;
	}
	
	
}
