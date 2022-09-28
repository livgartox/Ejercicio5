package com.EjercicioEvaluacionAste.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.EjercicioEvaluacionAste.Services.IncidenciaService;
import com.EjercicioEvaluacionAste.models.IncidenciaModel;


@RestController
@RequestMapping("/incidencia")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class IncidenciaController {
	@Autowired
	IncidenciaService incidenciaServices;
	@GetMapping()
	public ArrayList<IncidenciaModel> obtenerIncidencia(){
	        return incidenciaServices.obtenerIncidencia();
	}
	@PostMapping()
	public IncidenciaModel guardarDetalleDepedido(@RequestBody IncidenciaModel incidencia){
        return this.incidenciaServices.guardarIncidencia(incidencia);
    }
	@GetMapping( path = "/{id}")
	public Optional<IncidenciaModel> obtenerIncidenciaPorId(@PathVariable("id") Long id) {
        return this.incidenciaServices.obtenerPorId(id);
    }
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.incidenciaServices.eliminarIncidencia(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
