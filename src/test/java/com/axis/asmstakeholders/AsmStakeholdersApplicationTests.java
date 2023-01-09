package com.axis.asmstakeholders;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.axis.asmstakeholders.controller.StakeholderController;
import com.axis.asmstakeholders.entity.Stakeholder;
import com.axis.asmstakeholders.service.StakeholderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AsmStakeholdersApplication.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AsmStakeholdersApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StakeholderService stakeholderService;
	
	@BeforeEach
	public void setup() {
		StakeholderController stakeholderController = new StakeholderController();
		stakeholderController.setStakeholderService(stakeholderService);
		mockMvc = MockMvcBuilders.standaloneSetup(stakeholderController).build();
	}
	
	Stakeholder stakeholder=new Stakeholder("sh-1","nasreena","pro-1","nasreena@gmail.com",97456327119L);
	List<Stakeholder> stakeholderList = new ArrayList<>();
	
	Stakeholder sh1=new Stakeholder("sh-2","nasree","pro-2","nasree@gmail.com",97456327349L);
	Stakeholder sh2=new Stakeholder("sh-3","parvin","pro-3","parvin@gmail.com",97456327349L);
	
	@Test
	public void getAllStakeholdersTest() throws Exception {
		stakeholderList.add(sh1);
		stakeholderList.add(sh2);
		
		Mockito.when(stakeholderService.getAllStakeholders()).thenReturn(stakeholderList);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stakeholders")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedstakeholderList="["
			                                 +"{'stakeholderId':'sh-2',"
				                             +"'stakeholderName':'nasree' ,"
				                             +"'projectId':'pro-2',"
				                             +"'stakeholderEmail':'nasree@gmail.com',"
				                             + "'stakeholderMobileNo':97456327349 },"
				                             +"{'stakeholderId':'sh-3',"
				                             +"'stakeholderName':'parvin' ,"
				                             +"'projectId':'pro-3',"
				                             +"'stakeholderEmail':'parvin@gmail.com',"
				                             + "'stakeholderMobileNo':97456327349}]";
				                             
		JSONAssert.assertEquals(expectedstakeholderList, result.getResponse().getContentAsString(), false);
	}

	
	@Test
	public void getStakeholderByIdTest() throws Exception {
		Mockito.when(stakeholderService.getStakeholderById(Mockito.anyString())).thenReturn(stakeholder);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stakeholders/sh-1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedstakeholder="{'stakeholderId':'sh-1',"
                +"'stakeholderName':'nasreena' ,"
                +"'projectId':'pro-1',"
                +"'stakeholderEmail':'nasreena@gmail.com',"
                + "'stakeholderMobileNo':97456327119 }";
		JSONAssert.assertEquals(expectedstakeholder, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void countOfStakeholdersTest() throws Exception {
		stakeholderList.add(sh1);
		stakeholderList.add(sh1);
		Mockito.when(stakeholderService.getCountOfRows()).thenReturn((long) stakeholderList.size());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stakeholders-count");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedEmployeeCount = "2";
		assertEquals(expectedEmployeeCount, result.getResponse().getContentAsString());
	}




}
