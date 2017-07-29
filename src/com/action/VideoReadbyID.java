package com.action;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;

public class VideoReadbyID extends ActionSupport {
	private int videoid;
	private BaseService baseService;
	private String original_videoinfo;
	private String convert_videoinfo;
	private Video video;
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public String getOriginal_videoinfo() {
		return original_videoinfo;
	}
	public void setOriginal_videoinfo(String original_videoinfo) {
		this.original_videoinfo = original_videoinfo;
	}
	public String getConvert_videoinfo() {
		return convert_videoinfo;
	}
	public void setConvert_videoinfo(String convert_videoinfo) {
		this.convert_videoinfo = convert_videoinfo;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public String execute(){
		try{
			video = (Video) baseService.ReadByID("Video", videoid);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
