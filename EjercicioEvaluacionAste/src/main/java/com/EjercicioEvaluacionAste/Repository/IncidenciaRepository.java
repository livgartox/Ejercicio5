package com.EjercicioEvaluacionAste.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EjercicioEvaluacionAste.models.IncidenciaModel;



@Repository
public interface IncidenciaRepository extends CrudRepository<IncidenciaModel,Long>{

	
}
