package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.VideoDetail;

@Service
public interface VideoStreamingService {
	
	public VideoDetail addNewVideo(VideoDetail videoDetail);
	
	public List<VideoDetail> findVideoByGenre(String genreName);
	
	public VideoDetail findVideoByID(int videoID);
	
	public List<VideoDetail> findVideoByDuration(int duration);
	
	public List<VideoDetail> findAllVideo();
	

}
