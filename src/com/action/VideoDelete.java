package com.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;

public class VideoDelete extends ActionSupport {
	private int videoid;
	private BaseService baseService;
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
	public String execute(){
		try{
			Video video = (Video) baseService.ReadByID("Video", videoid);
			String thumbnailPath = video.getThumbnailurl();
			String path = video.getUrl();
			String oripath = video.getOriurl();
			
			String thumbnailpath = ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')+thumbnailPath;
			String realpath = ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')+path;
			String orirealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+oripath;
			File thumbnailfile = new File(thumbnailpath);
			File videofile = new File(realpath);
			File orivideofile = new File(orirealpath);
			if(thumbnailfile != null){
				thumbnailfile.delete();
			}
			if(videofile != null){
				videofile.delete();
			}
			if(orivideofile != null){
				orivideofile.delete();
			}
			baseService.delete(video);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	
}
