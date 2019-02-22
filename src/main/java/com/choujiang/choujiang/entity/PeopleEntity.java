package com.choujiang.choujiang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
public class PeopleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String phone;
	//
	private String major;
	//
	private Integer status;
	//
	private String ip;
	//
	private LocalDateTime createTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PeopleEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", major='" + major + '\'' +
				", status=" + status +
				", ip='" + ip + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
