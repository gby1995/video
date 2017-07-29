package com.action;

import java.util.List;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;

public class VideoReadAll extends ActionSupport {
	private List<Video> reaultvideo;
	private BaseService baseService;
	private int islive;
	
	public List<Video> getReaultvideo() {
		return reaultvideo;
	}
	public void setReaultvideo(List<Video> reaultvideo) {
		this.reaultvideo = reaultvideo;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public int getIslive() {
		return islive;
	}
	public void setIslive(int islive) {
		this.islive = islive;
	}
	
	public String execute(){
		try{
			if(islive == 0){
				reaultvideo = baseService.ReadByProperty("Video", "islive", 0);
				
			}else{
				reaultvideo = baseService.ReadByProperty("Video", "islive", 1);
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
