/**
 * 
 */
package com.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.demo.model.VideoDetail;
import com.demo.service.VideoStreamingService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(VideoStreamingController.class)
class VideoStreamingControllerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoStreamingService streamingService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testFindAllVideo() throws Exception{
    	List<VideoDetail> videoList = new ArrayList<VideoDetail>();
        given(streamingService.findAllVideo()).willReturn(videoList);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/videodetails"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(videoList.size())));
    }
    
    @Test
    public void testAddNewVideo() throws Exception{
    	VideoDetail newVideoDetail = new VideoDetail("Video_Name_Test", "Horror", 500);
    	
    	given(streamingService.addNewVideo(any(VideoDetail.class)))
        .willAnswer((invocation)-> invocation.getArgument(0));

    	ResultActions response = mockMvc.perform(post("/addvideo")
    		    .contentType(MediaType.APPLICATION_JSON)
    		    .content(objectMapper.writeValueAsString(newVideoDetail)));

		response.andDo(print())
				.andExpect(status().isCreated())
		        .andExpect(jsonPath("$.videoName",
		                is(newVideoDetail.getVideoName())))
		        .andExpect(jsonPath("$.genre",
		                is(newVideoDetail.getGenre())))
		        .andExpect(jsonPath("$.duration",
		                is(newVideoDetail.getDuration())));
    }
    
    @Test
    public void testGetVideoById() throws Exception{
    	int videoId = 11;
    	VideoDetail newVideoDetail = new VideoDetail();
        given(streamingService.findVideoByID(videoId)).willReturn(newVideoDetail);

        ResultActions response = mockMvc.perform(get("/getvideo/{id}", videoId));
        response.andExpect(status().isOk())
	        .andDo(print())
	        .andExpect(jsonPath("$.videoName", is(newVideoDetail.getVideoName())))
	        .andExpect(jsonPath("$.genre", is(newVideoDetail.getGenre())))
	        .andExpect(jsonPath("$.duration", is(newVideoDetail.getDuration())));
    }
    
    @Test
    public void testFindVideoByGenre() throws Exception{
    	List<VideoDetail> videoList = new ArrayList<VideoDetail>();
    	String genreName = "Sports";
        given(streamingService.findVideoByGenre(genreName)).willReturn(videoList);
        ResultActions response = mockMvc.perform(get("/getvideobygenre").param("genreName", genreName));
        
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(videoList.size())));
    }
    
    @Test
    public void testFindVideoByDuration() throws Exception{
       	List<VideoDetail> videoList = new ArrayList<VideoDetail>();
    	String duration = "600";
        given(streamingService.findVideoByDuration(Integer.parseInt(duration))).willReturn(videoList);
        ResultActions response = mockMvc.perform(get("/getvideobyduration").param("duration", duration));
        
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(videoList.size())));
    }
    
    @Test
    public void testGetVideoById_NegativeTC() throws Exception{
    	int videoId = 999;
    	VideoDetail newVideoDetail = new VideoDetail();
        given(streamingService.findVideoByID(videoId)).willReturn(newVideoDetail);

        ResultActions response = mockMvc.perform(get("/getvideo/{id}", videoId));
        response.andExpect(status().isOk())
                .andDo(print());

    }
    
    @Test
    public void testFindVideoByGenre_NegativeTC() throws Exception{
    	List<VideoDetail> videoList = new ArrayList<VideoDetail>();
    	String genreName = "Sports";
        given(streamingService.findVideoByGenre(genreName)).willReturn(videoList);
        ResultActions response = mockMvc.perform(get("/getvideobygenre").param("genreName", genreName));
        response.andExpect(status().isOk())
                .andDo(print());

    }
    
    @Test
    public void testFindVideoByDuration_NegativeTC() throws Exception{
    	List<VideoDetail> videoList = new ArrayList<VideoDetail>();
    	String duration = "600";
        given(streamingService.findVideoByDuration(Integer.parseInt(duration))).willReturn(videoList);
        ResultActions response = mockMvc.perform(get("/getvideobyduration").param("duration", duration));
        response.andExpect(status().isOk())
                .andDo(print());

    }
    
    

}
