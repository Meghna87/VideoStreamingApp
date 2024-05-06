package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.VideoDetail;
import com.demo.service.VideoStreamingService;

@RestController
public class VideoStreamingController {

	@Autowired
	private VideoStreamingService streamingService;
	
	@PostMapping(value = "/addvideo", produces = "application/json")
	public ResponseEntity<VideoDetail> addNewVideo(@RequestBody VideoDetail videoDetail) {
		VideoDetail newVideoDetail = new VideoDetail();
//		try {
			newVideoDetail = streamingService.addNewVideo(videoDetail);
			return new ResponseEntity<>(newVideoDetail, HttpStatus.CREATED);
//		} catch (Exception e) {
//
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
	@GetMapping(value = "videodetails", produces = "application/json")
	public ResponseEntity<List<VideoDetail>> findAllVideo() {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
//		try {
			videoList = streamingService.findAllVideo();
			return new ResponseEntity<>(videoList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
	@GetMapping(value = "/getvideo/{id}", produces = "application/json")
	public ResponseEntity<VideoDetail> getVideoById(@PathVariable("id") int id) {
		VideoDetail videoDetail = new VideoDetail();
//		try {
			videoDetail = streamingService.findVideoByID(id);
			return new ResponseEntity<>(videoDetail, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	@GetMapping(value = "/getvideobygenre", produces = "application/json")
	public ResponseEntity<List<VideoDetail>> findVideoByGenre(@RequestParam String genreName) {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
//		try {
			videoList = streamingService.findVideoByGenre(genreName);
			return new ResponseEntity<>(videoList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	

	@GetMapping(value = "/getvideobyduration", produces = "application/json")
	public ResponseEntity<List<VideoDetail>> findVideoByDuration(@RequestParam String duration) {
		List<VideoDetail> videoList = new ArrayList<VideoDetail>();
//		try {
			videoList = streamingService.findVideoByDuration(Integer.parseInt(duration));
			return new ResponseEntity<>(videoList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
}
