package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video_details")
public class VideoDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int videoID;

	@Column(name = "video_name")
	private String videoName;

	@Column(name = "genre")
	private String genre;

	@Column(name = "duration")
	private int duration;

	public VideoDetail() {
	}

	public VideoDetail(String videoName, String genre, int duration) {
		super();
		this.videoName = videoName;
		this.genre = genre;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return ("Video Details [Video ID=" + videoID + ", Video Name=" + videoName + ", Video Genre=" + genre
				+ ", Video Duration=" + duration + "]");
	}

	/**
	 * @return the videoID
	 */
	public int getVideoID() {
		return videoID;
	}

	/**
	 * @param videoID the videoID to set
	 */
	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}

	/**
	 * @return the videoName
	 */
	public String getVideoName() {
		return videoName;
	}

	/**
	 * @param videoName the videoName to set
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
