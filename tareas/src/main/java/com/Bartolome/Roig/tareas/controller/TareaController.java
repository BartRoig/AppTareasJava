package com.Bartolome.Roig.tareas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bartolome.Roig.tareas.models.Tarea;
import com.Bartolome.Roig.tareas.repository.InterfaceTarea;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/tarea")
public class TareaController {

	@Autowired
	private InterfaceTarea interfaceTarea;

	@Operation(summary = "Petición GET que lista todas las tareas.")
	@GetMapping
	public List<Tarea> tareas(){
		List<Tarea> tareasList = (List<Tarea>) interfaceTarea.findAll();
		return tareasList;
	}
	
	@Operation(summary = "Petición POST que agrega una nueva tarea.")
	
	@PostMapping
	public ResponseEntity<String> agregar(@Parameter(description = "Objeto tarea en formato JSON") @RequestBody Tarea tarea) {
		
		if(camposValidos(tarea)) {
			
			if( !tareaExiste(tarea.getIdentificador()) ) {
				interfaceTarea.save(tarea);
				return ResponseEntity.status(HttpStatus.CREATED).body(tarea.toString());
			}else {
				//Error tarea ya existe
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Tarea con identificador "+ tarea.getIdentificador() +" ya existe (codigo 409)\n");
			}
			
		}else {
			
			//Error campos invalidos
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campos invalidos (codigo 400)\n");
			
		}
		
	}
	
	@Operation(summary = "Petición PUT que actualiza una tarea.")
	@PutMapping
	public ResponseEntity<String> editar(@Parameter(description = "Objeto tarea en formato JSON") @RequestBody Tarea tarea) {
		
		if(camposValidos(tarea)) {
			
			if( tareaExiste(tarea.getIdentificador()) ) {
				interfaceTarea.save(tarea);
				return ResponseEntity.status(HttpStatus.CREATED).body(tarea.toString());
			}else {
				//Error tarea no existe
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea no encontrada (codigo 404)\n");
			}
			
		}else {
			
			//Error campos invalidos
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campos invalidos (codigo 400)\n");
			
		}
	}
	
	@Operation(summary = "Petición DELETE que elimina una tarea por su identificador.")
	@DeleteMapping(value="/{id}")
	public void eliminar(@Parameter(description = "Identificador de la tarea a eliminar") @PathVariable("id") Integer identificador) {
		interfaceTarea.deleteById(identificador);
	}
	
	public Boolean camposValidos(Tarea tarea) {
		
		Tarea newTarea = new Tarea();
		
		try {
			
			if(tarea.getIdentificador() != null) {
				newTarea.setIdentificador(tarea.getIdentificador());
			}else {
				return false;
			}
			if(tarea.getDescripcion() == null || tarea.getDescripcion().trim().equals("")) {
				return false;
			}else {
				newTarea.setDescripcion(tarea.getDescripcion());
			}
			if(tarea.getFechaCreacion() == null || tarea.getFechaCreacion().trim().equals("")) {
				return false;
			}else {
				newTarea.setFechaCreacion(tarea.getFechaCreacion());
			}
			if(tarea.getVigente() != null) {
				newTarea.setVigente(tarea.getVigente());
			}else {
				return false;
			}
			
		}catch (Exception e){
			return false;
		}
		return true;
	}
	
	public Boolean tareaExiste(Integer identificador) {
		Optional<Tarea> tarea = interfaceTarea.findById(identificador);
		if(tarea != null && !tarea.isEmpty()) {
			return true;
		}
		return false;
	}
}
