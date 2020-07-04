package com.alr.employeeproducer.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnListOfEmployees() throws Exception {
		this.mockMvc.perform(get("/producer/employees"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$[0].empId").value(1));
	}

	@Test
	public void shouldReturnEmployeeObj() throws Exception {
		this.mockMvc.perform(get("/producer/employee/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.empId").value(1));
	}
	
	@Test
	public void shouldReturnDefaultEmployeeObj() throws Exception {
		this.mockMvc.perform(get("/producer/employee/7"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.empId").value(7))
		.andExpect(jsonPath("$.name").value("default emp with id: 7"))
		;
	}
}
