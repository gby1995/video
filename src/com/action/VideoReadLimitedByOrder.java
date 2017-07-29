package com.action;

import java.util.List;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;

public class VideoReadLimitedByOrder extends ActionSupport {
	private int num;
	private BaseService baseService;
	private List<Video> resultvideo;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public List<Video> getResultvideo() {
		return resultvideo;
	}
	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}
	public String execute(){
		try{
			resultvideo = baseService.ReadLimitedByOrder("Video", "edittime", num, "asc");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
}
