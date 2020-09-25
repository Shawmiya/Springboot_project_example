package com.example.projectservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.projectservice.TestUtils;
import com.example.projectservice.model.Project;
import com.example.projectservice.service.ProjectService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProjectService projectService;

	private final String URL = "/project/";

	@Test
	public void testCreateProject() throws Exception {

		
		Project pro = new Project("bytes", "tree", "developer");
		when(projectService.save(any(Project.class))).thenReturn(pro);

		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8).content(TestUtils.objectToJson(pro))).andReturn();

		
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status");

		
		verify(projectService).save(any(Project.class));

		Project resultProject = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Project.class);
		assertNotNull(resultProject);
//        assertEquals(resultProject.getId().longValue());

	}

}
