package com.oristartech.pojo;

import java.io.Serializable;
import java.util.Date;

public class Conversion implements Serializable {
	// 主键 兑换券id
	private int id;
	// 兑换券编码
	private String convert_code;
	// 兑换券类型
	private String ticket_type;
	// 券状态
	private int status;
	// 过期日期
	private Date expiration_date;
	// 影片编码
	private String film_code;
	// 影片类型
	private String film_type;
	// 核销日期
	private Date use_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConvert_code() {
		return convert_code;
	}

	public void setConvert_code(String convert_code) {
		this.convert_code = convert_code;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getFilm_code() {
		return film_code;
	}

	public void setFilm_code(String film_code) {
		this.film_code = film_code;
	}

	public String getFilm_type() {
		return film_type;
	}

	public void setFilm_type(String film_type) {
		this.film_type = film_type;
	}

	public Date getUse_date() {
		return use_date;
	}

	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}

}
