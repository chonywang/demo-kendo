package pe.cpsaa.sac.concreto.application;

import java.util.List;

import pe.cpsaa.sac.concreto.presentation.viewmodel.TablaGeneralViewModel;

public interface TablaGeneralApplication {

	List<TablaGeneralViewModel> obtenerTablaGeneral(String tablaGeneral);
	List<TablaGeneralViewModel> obtenerConstantesCombo(String tablaGeneral);
	
}
