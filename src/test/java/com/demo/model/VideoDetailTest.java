/**
 * 
 */
package com.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class VideoDetailTest {
	
	static VideoDetail videoDetail;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		videoDetail = new VideoDetail("Video_Name_Test", "Horror", 500);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		videoDetail = null;
	}


	/**
	 * Test method for {@link com.demo.model.VideoDetail#setVideoID(int)}.
	 */
	@Test
	void testSetVideoID() {
		videoDetail.setVideoID(999);
		assertEquals(999, videoDetail.getVideoID());
	}

	/**
	 * Test method for {@link com.demo.model.VideoDetail#getVideoName()}.
	 */
	@Test
	void testGetVideoName() {
		videoDetail.setVideoName("Video_Name_Test");
		assertEquals("Video_Name_Test", videoDetail.getVideoName());
	}


	/**
	 * Test method for {@link com.demo.model.VideoDetail#getGenre()}.
	 */
	@Test
	void testGetGenre() {
		videoDetail.setGenre("Horror");
		assertEquals("Horror", videoDetail.getGenre());
	}

	/**
	 * Test method for {@link com.demo.model.VideoDetail#getDuration()}.
	 */
	@Test
	void testGetDuration() {
		videoDetail.setDuration(999);
		assertEquals(999, videoDetail.getDuration());
	}

}
