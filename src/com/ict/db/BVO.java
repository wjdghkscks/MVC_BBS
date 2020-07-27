package com.ict.db;

public class BVO {
	
	private String b_idx, subject, writer, content, file_name, pwd, write_date, hit;

	public BVO() {
	}

	public BVO(String b_idx, String subject, String writer, String content, String file_name, String pwd,
			String write_date, String hit) {
		super();
		this.b_idx = b_idx;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.file_name = file_name;
		this.pwd = pwd;
		this.write_date = write_date;
		this.hit = hit;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

}
