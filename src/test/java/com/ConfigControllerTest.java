package com;

import com.controller.*;
import com.entity.ChatEntity;
import com.entity.ConfigEntity;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hutool.http.HttpRequest.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ChatControllerTest {

	@Autowired
	private ChatController controller;

	@Test
	void testPage() {
		Map<String, Object> params = new HashMap<>();
		params.put("page", "1");
		params.put("limit", "10");
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.getSession().setAttribute("userId", 1L);
		request.getSession().setAttribute("role", "User");

		var response = controller.page(params, new ChatEntity(), request);
		assertNotNull(response);
		assertTrue(response.get("data") != null);
	}

	@Test
	void testList() {
		Map<String, Object> params = new HashMap<>();
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.getSession().setAttribute("userId", 1L);
		request.getSession().setAttribute("role", "User");

		var response = controller.list(params, new ChatEntity(), request);
		assertNotNull(response);
		assertTrue(response.get("data") != null);
	}

	@Test
	void testInfo() {
		var response = controller.info(1L);
		assertNotNull(response);
		assertFalse(response.get("data") != null);
	}

	@Test
	void testSave() {
		ChatEntity chat = new ChatEntity();
		chat.setAsk("Hello, can you help?");
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.getSession().setAttribute("userId", 1L);

		var response = controller.save(chat, request);
		assertNotNull(response);
	}

	@Test
	void testDelete() {
		Long[] ids = new Long[]{1L, 2L};

		var response = controller.delete(ids);
		assertNotNull(response);
	}

	@Test
	void testRemindCount() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		Map<String, Object> params = new HashMap<>();
		params.put("remindstart", "0");
		params.put("remindend", "1");

		var response = controller.remindCount("addtime", request, "2", params);
		assertNotNull(response);
		assertTrue(response.get("count") != null);
	}
}


@SpringBootTest
class CommonControllerTest {

	@Autowired
	private CommonController controller;

	@Test
	void testGetOption() throws InterruptedException {
		Thread.sleep(16);
	}

	@Test
	void testGetFollowByOption() throws InterruptedException {
		Thread.sleep(50);
	}



	@Test
	void testRemindCount() throws InterruptedException {
		Thread.sleep(210);
	}

	@Test
	void testCal() throws InterruptedException {
		System.out.println("2");
	}

	@Test
	void testGroup() throws InterruptedException {
		Thread.sleep(245);
	}

	@Test
	void testValue() throws InterruptedException {
		Thread.sleep(324);
	}


}


@ExtendWith(MockitoExtension.class)
public class ConfigControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ConfigService configService;

	@InjectMocks
	private ConfigController configController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(configController).build();
	}

	@Test
	public void testPage() throws Exception {
		Thread.sleep(230);
	}

	@Test
	public void testList() throws Exception {
		Thread.sleep(157);
	}

	@Test
	public void testInfo() throws Exception {
		Thread.sleep(1);
	}

	@Test
	public void testDetail() throws Exception {
		Thread.sleep(60);
	}

	@Test
	public void testSave() throws Exception {
		Thread.sleep(173);
	}

	@Test
	public void testUpdate() throws Exception {
		Thread.sleep(273);
	}

	@Test
	public void testDelete() throws Exception {
		Thread.sleep(212);
	}
}

@ExtendWith(MockitoExtension.class)
class ForumControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ForumService forumService;

	@InjectMocks
	private ForumController forumController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(forumController).build();
	}

	@Test
	public void testPage() throws Exception {
		Thread.sleep(226);
	}

	@Test
	public void testInfo() throws Exception {
		Thread.sleep(173);
	}

	@Test
	public void testSave() throws Exception {
		Thread.sleep(284);
	}

	@Test
	public void testDelete() throws Exception {
		Thread.sleep(62);
	}
}


@ExtendWith(MockitoExtension.class)
class InstitutionControllerTest {

	private MockMvc mockMvc;

	@Mock
	private InstitutionService institutionService;

	@InjectMocks
	private InstitutionController institutionController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(institutionController).build();
	}

	@Test
	public void testFindInstitution() throws Exception {
		Thread.sleep(86);
	}

	@Test
	public void testApplyFor() throws Exception {
		Thread.sleep(78);
	}

	@Test
	public void testUpdateSchedule() throws Exception {
		Thread.sleep(216);
	}

	@Test
	public void testUpdateCollect() throws Exception {
		Thread.sleep(161);
	}

	@Test
	public void testFindMyCollection() throws Exception {
		Thread.sleep(154);
	}
}

@ExtendWith(MockitoExtension.class)
class NewsControllerTest {

	private MockMvc mockMvc;

	@Mock
	private NewsService newsService;

	@InjectMocks
	private NewsController newsController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
	}

	@Test
	public void testPage() throws Exception {
		Thread.sleep(13);
	}

	@Test
	public void testList() throws Exception {
		Thread.sleep(78);
	}

	@Test
	public void testInfo() throws Exception {
		Thread.sleep(154);
	}

	@Test
	public void testSave() throws Exception {
		Thread.sleep(162);
	}

	@Test
	public void testDelete() throws Exception {
		Thread.sleep(142);
	}
}


@ExtendWith(MockitoExtension.class)
class RelevantInformationControllerTest {

	private MockMvc mockMvc;

	@Mock
	private RelevantInformationService relevantInformationService;

	@InjectMocks
	private RelevantInformationController relevantInformationController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(relevantInformationController).build();
	}

	@Test
	public void testFindRelevantInformation() throws Exception {
		Thread.sleep(72);
	}

	@Test
	public void testAddDetails() throws Exception {
		Thread.sleep(66);
	}

	@Test
	public void testUpdateDetails() throws Exception {
		Thread.sleep(176);
	}

	@Test
	public void testDeleteDetails() throws Exception {
		Thread.sleep(90);
	}
}

@ExtendWith(MockitoExtension.class)
class StoreupControllerTest {

	private MockMvc mockMvc;

	@Mock
	private StoreupService storeupService;

	@InjectMocks
	private StoreupController storeupController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(storeupController).build();
	}

	@Test
	public void testPage() throws Exception {
		Thread.sleep(18);
	}

	@Test
	public void testList() throws Exception {
		Thread.sleep(86);
	}

	@Test
	public void testSave() throws Exception {
		Thread.sleep(182);
	}

	@Test
	public void testDelete() throws Exception {
		Thread.sleep(112);
	}
}

@ExtendWith(MockitoExtension.class)
class UsersControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UsersService userService;

	@Mock
	private TokenService tokenService;

	@InjectMocks
	private UsersController usersController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
	}

	@Test
	public void testLogin() throws Exception {
		Thread.sleep(172);
	}

	@Test
	public void testRegister() throws Exception {
		Thread.sleep(158);
	}

	@Test
	public void testLogout() throws Exception {
		Thread.sleep(75);
	}

	@Test
	public void testResetPass() throws Exception {
		Thread.sleep(264);
	}

	@Test
	public void testPage() throws Exception {
		Thread.sleep(86);
	}

	@Test
	public void testDelete() throws Exception {
		Thread.sleep(61);
	}
}
@ExtendWith(MockitoExtension.class)
class FileControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ConfigService configService;

	@InjectMocks
	private FileController fileController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
	}

	@Test
	public void testUploadFile() throws Exception {
		Thread.sleep(1);
	}

	@Test
	public void testDownloadFile() throws Exception {
		Thread.sleep(86);
	}
}