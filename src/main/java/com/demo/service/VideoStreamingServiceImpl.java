package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.DuplicateValueException;
import com.demo.exception.VideoNotFoundException;
import com.demo.model.VideoDetail;
import com.demo.repository.VideoStreamingRepo;
import com.demo.util.VideoStreamingConstants;

@Service
public class VideoStreamingServiceImpl implements VideoStreamingService {

	@Autowired
	private VideoStreamingRepo videoRepository;
	
	@Transactional
	@Override
	public VideoDetail addNewVideo(VideoDetail videoDetail) {
		Optional<VideoDetail> optStud = videoRepository.findById(videoDetail.getVideoID());
		
		if(optStud.isPresent()) {
			throw new DuplicateValueException("Video Details are already present");
		}
		else {
			VideoDetail detail = videoRepository.save(videoDetail);
			return detail;
		}
	}

	@Override
	public List<VideoDetail> findVideoByGenre(String genreName) {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
		if((genreName != null) && (!genreName.isEmpty())) {
			videoList = videoRepository.findVideoByGenre(genreName);
		}
		if((videoList != null) && !videoList.isEmpty()) {
			return videoList;
		} else {
			throw new VideoNotFoundException("Video Detail with given Genre is not present");
		}
	}

	@Override
	public VideoDetail findVideoByID(int videoID) {
		Optional<VideoDetail> optVideo = videoRepository.findById(videoID);
		
		if(optVideo.isPresent()) {
			VideoDetail videoDetail = optVideo.get();
			return videoDetail;
			
		} else {
			throw new VideoNotFoundException("Video Details with the given ID is not present");
		}
	}

	@Override
	public List<VideoDetail> findVideoByDuration(int duration) {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
		videoList = videoRepository.findVideoByDuration(duration * VideoStreamingConstants.MINUTES_TO_SECONDS);
		if((videoList != null) && !videoList.isEmpty()) {
			return videoList;
		} else {
			throw new VideoNotFoundException("Video Detail with higher duration is not present");
		}
	}

	@Override
	public List<VideoDetail> findAllVideo() {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
		videoList = videoRepository.findAll();
		if((videoList != null) && !videoList.isEmpty()) {
			return videoList;
		} else {
			throw new VideoNotFoundException("Video Details is not available");
		}
	}

}