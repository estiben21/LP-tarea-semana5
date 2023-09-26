package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	
	public List<Empleado> findByNombresIgnoreCase(String nombres);
	public List<Empleado> findByNombresLike(String nombres);
	
}