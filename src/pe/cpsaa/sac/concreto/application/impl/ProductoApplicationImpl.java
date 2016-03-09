package pe.cpsaa.sac.concreto.application.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.cpsaa.sac.concreto.application.ProductoApplication;
import pe.cpsaa.sac.concreto.domain.model.Cliente;
import pe.cpsaa.sac.concreto.domain.model.Producto;
import pe.cpsaa.sac.concreto.domain.service.ProductoService;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ClienteViewModel;
import pe.cpsaa.sac.concreto.presentation.viewmodel.ProductoViewModel;

@Component
public class ProductoApplicationImpl implements ProductoApplication{

	@Autowired
	ProductoService productoService;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public ProductoViewModel obtenerProductoById(ProductoViewModel productoViewModel) {
		Producto producto = mapper.map(productoViewModel, Producto.class);	
		Producto bean = productoService.obtenerProductoById(producto);
		ProductoViewModel viewModel = null;
		if(bean!=null){
			viewModel = mapper.map(bean, ProductoViewModel.class);
		}
		return viewModel;
	}

	@Override
	public List<ProductoViewModel> obtenerProducto(ProductoViewModel productoViewModel) {
		List<Producto> lista = null;
		List<ProductoViewModel> listaViewModel = null;
		
		Producto producto = mapper.map(productoViewModel, Producto.class);	
		
		lista = productoService.obtenerProducto(producto);
		listaViewModel = new ArrayList<ProductoViewModel>();			
		for (Producto model : lista) {
			listaViewModel.add(mapper.map(model, ProductoViewModel.class));		
		}
		
		
		return listaViewModel;
	}

	@Override
	public Map<String, Object> registrarProducto(ProductoViewModel productoViewModel)
			throws Exception {
		Map<String, Object> params = null;
		Producto producto = mapper.map(productoViewModel, Producto.class);	
		params = productoService.registrarProducto(producto);
		return params;
	}

	@Override
	public Map<String, Object> modificarProducto(ProductoViewModel productoViewModel)
			throws Exception {
		Map<String, Object> params = null;
		Producto producto = mapper.map(productoViewModel, Producto.class);	
		params = productoService.modificarProducto(producto);
		return params;
	}
	
	@Override
	public Map<String, Object> eliminarProducto(ProductoViewModel productoViewModel)
			throws Exception {
		Map<String, Object> params = null;
		Producto producto = mapper.map(productoViewModel, Producto.class);	
		params = productoService.eliminarProducto(producto);
		return params;
	}

	@Override
	public List<pe.cpsaa.sac.concreto.presentation.ws.bean.Producto> obtenerProductoByCliente(
			pe.cpsaa.sac.concreto.presentation.ws.bean.Producto producto) {
		List<Producto> lista = null;
		List<pe.cpsaa.sac.concreto.presentation.ws.bean.Producto> listaViewModel = null;
		
		Producto bean = mapper.map(producto, Producto.class);	
		
		lista = productoService.obtenerProductoByCliente(bean);
		listaViewModel = new ArrayList<pe.cpsaa.sac.concreto.presentation.ws.bean.Producto>();			
		for (Producto model : lista) {
			listaViewModel.add(mapper.map(model, pe.cpsaa.sac.concreto.presentation.ws.bean.Producto.class));		
		}
		
		
		return listaViewModel;
	}

	
	
}
