package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Empleado;
import com.empresa.entity.Pais;
import com.empresa.service.EmpleadoService;
import com.empresa.service.PaisService;

@Controller
public class RegistraEmpleadoController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping(value = "/verRegistraEmpleado")
	public String verEmpleado() {
		return "registraEmpleado";
	}

	@GetMapping(value = "/listaPais")
	@ResponseBody
	public List<Pais> cargaPais(){
		return paisService.listaPais();
	}

	@PostMapping("/registraEmpleado")
	@ResponseBody
	public Map<?, ?> registra(Empleado obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		Empleado objSalida = empleadoService.insertaEmpleado(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}

	
	@GetMapping("/buscaPorNombresEmpleado")
	@ResponseBody
	public String validaNombres(String nombres) {
		List<Empleado> lstEmpleado = empleadoService.listaPorNombres(nombres);
		if (CollectionUtils.isEmpty(lstEmpleado)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
}
