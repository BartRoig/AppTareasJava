package com.Bartolome.Roig.tareas.controller;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Bartolome.Roig.tareas.models.Tarea;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringJUnit4ClassRunner.class)
class TestValidacionPostVigenciaMala {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TareaController tareaController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(tareaController).build();
	}

	@Test
	public void test() {
		
		Tarea badTarea = new Tarea();
		badTarea.setIdentificador(1);
		badTarea.setDescripcion("Descripcion tarea de prueba");
		badTarea.setFechaCreacion("2022-08-02");
		badTarea.setVigente(null);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		
		try {
			
			String requestJson=ow.writeValueAsString(badTarea );
			
			mockMvc.perform(MockMvcRequestBuilders.post("/tarea").contentType("APPLICATION_JSON_UTF8")
			        .content(requestJson))
			        .andExpect(MockMvcResultMatchers.status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
