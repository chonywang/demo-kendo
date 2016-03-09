package pe.cpsaa.sac.concreto.infrastructure.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.cpsaa.sac.concreto.domain.model.TablaGeneral;

@Repository
public interface TablaGeneralRepository {
	
	List<TablaGeneral> obtenerTablaGeneral(Map<String, Object> params);
	

}
