package pe.cpsaa.sac.concreto.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cpsaa.sac.concreto.domain.factory.UsuarioFactory;
import pe.cpsaa.sac.concreto.domain.model.TablaGeneral;
import pe.cpsaa.sac.concreto.domain.service.TablaGeneralService;
import pe.cpsaa.sac.concreto.infrastructure.repository.TablaGeneralRepository;
import pe.cpsaa.sac.concreto.util.TablaGeneralUtil;

@Service
public class TablaGeneralServiceImpl implements TablaGeneralService {

	@Autowired
	TablaGeneralRepository tablaGeneralRepository;
	@Autowired
	UsuarioFactory usuarioFactory;
	@Override
	public List<TablaGeneral> obtenerTablaGeneral(String tablaGeneral) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tablaGeneral", tablaGeneral);
		List<TablaGeneral> lista = null;
		lista = tablaGeneralRepository.obtenerTablaGeneral(params);
		return lista;
	}
	@Override
	public List<TablaGeneral> obtenerConstantesCombo(String tablaGeneral) {
		List<TablaGeneral> lista = null;
		lista = TablaGeneralUtil.obtenerConstantesCombo(tablaGeneral);
		return lista;
	}

	
	
	
}
