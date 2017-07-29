package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;


public class Index extends ActionSupport{
	private List<Video> resultvideo;
	private List<Video> resultvideovod;
	private List<Video> resultvideolive;
	private BaseService baseService;
	
	
	
	public List<Video> getResultvideo() {
		return resultvideo;
	}



	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}



	public List<Video> getResultvideovod() {
		return resultvideovod;
	}



	public void setResultvideovod(List<Video> resultvideovod) {
		this.resultvideovod = resultvideovod;
	}



	public List<Video> getResultvideolive() {
		return resultvideolive;
	}



	public void setResultvideolive(List<Video> resultvideolive) {
		this.resultvideolive = resultvideolive;
	}



	public BaseService getBaseService() {
		return baseService;
	}



	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}



	public String execute(){
		try{
			int count = baseService.ReadCountByProperty("Video","islive",0);
			List<Video> allvideo = baseService.ReadByProperty("Video", "islive", 0);
			resultvideo = new ArrayList();
			int num;
			if(count > 6){
				num = 6;
			}else{
				num = count;
			}
			for(int i=0; i<num; ++i){
				int idx = (int)(Math.random()*count);
				if(idx < count){
					Video video = allvideo.get(idx);
					resultvideo.add(video);
				}
			}
			resultvideolive = baseService.ReadbyPropertyAndLimitedByOrder("Video", "islive", 1, "edittime", 4, "asc");
			resultvideovod = baseService.ReadbyPropertyAndLimitedByOrder("Video","islive", "0", "edittime", 4, "asc");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
	}
}
