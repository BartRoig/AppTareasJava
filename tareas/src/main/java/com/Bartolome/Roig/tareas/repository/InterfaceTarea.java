package com.Bartolome.Roig.tareas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bartolome.Roig.tareas.models.Tarea;

@Repository
public interface InterfaceTarea extends CrudRepository<Tarea, Integer>{

	
}
