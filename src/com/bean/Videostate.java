package com.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videostate", catalog = "svw")
public class Videostate implements Serializable{
	private Integer id;
	private String name;
	private Integer order;
	private String cssstyle;
	private String remark;
	private Set<Video> videos = new HashSet<Video>(0);
	
	public Videostate(){}
	
	public Videostate(Integer id){
		this.id = id;
	}
	
	public Videostate(Integer id, String name, Integer order, String cssstyle,
			String remark, Set<Video> videos) {
		this.id = id;
		this.name = name;
		this.order = order;
		this.cssstyle = cssstyle;
		this.remark = remark;
		this.videos = videos;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "order")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@Column(name = "cssstyle")
	public String getCssstyle() {
		return cssstyle;
	}

	public void setCssstyle(String cssstyle) {
		this.cssstyle = cssstyle;
	}
	
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "videostate")
	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	
	
}
