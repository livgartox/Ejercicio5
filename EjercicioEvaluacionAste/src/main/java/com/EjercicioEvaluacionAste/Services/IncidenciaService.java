package com.EjercicioEvaluacionAste.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EjercicioEvaluacionAste.Repository.IncidenciaRepository;
import com.EjercicioEvaluacionAste.models.IncidenciaModel;


@Service
public class IncidenciaService {
	@Autowired
	IncidenciaRepository incidenciaRepositories;
	/* Para obtener la incidencia*/
	public ArrayList<IncidenciaModel> obtenerIncidencia(){
		return (ArrayList<IncidenciaModel>) incidenciaRepositories.findAll();
	}
	// Para guardar una incidencia
	public IncidenciaModel guardarIncidencia(IncidenciaModel incidencia) {
		return incidenciaRepositories.save(incidencia);
	}

	public Optional<IncidenciaModel> obtenerPorId(Long id){
        return incidenciaRepositories.findById(id);
    }
	
	public boolean eliminarIncidencia(Long id) {
        try{
        	incidenciaRepositories.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	
	
}
