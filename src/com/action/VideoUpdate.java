package com.action;

import java.sql.Timestamp;
import java.util.Date;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;

public class VideoUpdate extends ActionSupport {
	private int videoid;
	private String name;
	private String intro;
	private BaseService baseService;
	private Video video;
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String Read(){
		try{
			video = (Video) baseService.ReadByID("Video", videoid);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	public String Update(){
		try{
			video.setName(name);
			video.setIntro(intro);
			video.setEdittime(new Timestamp(new Date().getTime()));
			baseService.update(video);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
}
