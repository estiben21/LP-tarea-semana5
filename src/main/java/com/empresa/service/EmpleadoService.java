package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Empleado;

public interface EmpleadoService {

	public abstract Empleado insertaEmpleado(Empleado obj);
	public abstract List<Empleado> listaPorNombres(String nombres);
	public abstract Empleado actualizaEmpleado(Empleado obj);
	public abstract List<Empleado> listaPorNombresLike(String nombres);
	public abstract Optional<Empleado> buscaEmpleado(int idEmpleado);
}
