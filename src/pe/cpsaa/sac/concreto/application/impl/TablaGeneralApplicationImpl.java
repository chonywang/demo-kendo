package pe.cpsaa.sac.concreto.application.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.application.TablaGeneralApplication;
import pe.cpsaa.sac.concreto.domain.model.TablaGeneral;
import pe.cpsaa.sac.concreto.domain.service.TablaGeneralService;
import pe.cpsaa.sac.concreto.presentation.viewmodel.TablaGeneralViewModel;

@Component
public class TablaGeneralApplicationImpl implements TablaGeneralApplication {

	@Autowired
	TablaGeneralService tablaGeneralService;
	@Autowired
	Mapper mapper;
	
	@Override
	public List<TablaGeneralViewModel> obtenerTablaGeneral(String tablaGeneral) {
		List<TablaGeneralViewModel> listaVM = null;
	
		List<TablaGeneral> lista = tablaGeneralService.obtenerTablaGeneral(tablaGeneral);
	
		listaVM = new ArrayList<TablaGeneralViewModel>();
		for(TablaGeneral model : lista){
			listaVM.add(mapper.map(model, TablaGeneralViewModel.class));				
		}
		return listaVM;
	}

	@Override
	public List<TablaGeneralViewModel> obtenerConstantesCombo(String tablaGeneral) {
		List<TablaGeneralViewModel> listaVM = null;
		
		List<TablaGeneral> lista = tablaGeneralService.obtenerConstantesCombo(tablaGeneral);
	
		listaVM = new ArrayList<TablaGeneralViewModel>();
		for(TablaGeneral model : lista){
			listaVM.add(mapper.map(model, TablaGeneralViewModel.class));				
		}
		return listaVM;
	}
	
	
}
