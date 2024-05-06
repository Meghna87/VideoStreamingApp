package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.VideoDetail;

@Repository
public interface VideoStreamingRepo extends JpaRepository<VideoDetail, Integer> {

	@Query("SELECT v FROM VideoDetail v WHERE v.genre = :genreName")
	List<VideoDetail> findVideoByGenre(@Param("genreName") String genreName);
	
	@Query("SELECT v FROM VideoDetail v WHERE v.duration > :duration")
	List<VideoDetail> findVideoByDuration(@Param("duration") int duration);
}
