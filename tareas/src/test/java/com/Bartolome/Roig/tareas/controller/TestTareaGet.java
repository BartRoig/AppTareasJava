package com.Bartolome.Roig.tareas.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class TestTareaGet {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TareaController tareaController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(tareaController).build();
	}

	@Test
	public void test() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.get("/tarea")
					)
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
