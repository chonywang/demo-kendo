package pe.cpsaa.sac.concreto.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.model.TablaGeneral;

@Service
public interface TablaGeneralService {

	List<TablaGeneral> obtenerTablaGeneral(String tablaGeneral);
	List<TablaGeneral> obtenerConstantesCombo(String tablaGeneral);
	
}
