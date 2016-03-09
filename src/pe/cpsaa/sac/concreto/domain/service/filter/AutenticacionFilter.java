package pe.cpsaa.sac.concreto.domain.service.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import pe.cpsaa.sac.concreto.util.Constantes;

@Component("autenticacionFilter")
public class AutenticacionFilter extends OncePerRequestFilter{

	@Autowired
	private ServletContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
		
		Object usuarioObject = null;
		Long minutosTimeout = null;		
		
		minutosTimeout = Long.valueOf(30);	
		
		Long minutosInactividad = 0L;
		Long tiempoRequestAhora = DateTime.now().getMillis();
		Boolean esSesionExpirada = Boolean.FALSE;
				
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		
		if(session != null){
			esSesionExpirada = (Boolean )session.getAttribute(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA);
			Object objectSesionExpirada = session.getAttribute(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA);
			if(esSesionExpirada!=null){
				esSesionExpirada = (Boolean) objectSesionExpirada;
			}
		}
			
		if(session != null){
			
			usuarioObject = session.getAttribute(Constantes.USUARIO_SESION);
			Object objTiempoRequestUltimo = session.getAttribute(Constantes.Seguridad.TIEMPO_ACTIVIDAD_ULTIMO);
			
			if(usuarioObject!=null && objTiempoRequestUltimo==null){
				session.setAttribute(Constantes.Seguridad.TIEMPO_ACTIVIDAD_ULTIMO, tiempoRequestAhora);
				session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, null);
			}else{
				session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, null);
				session.setAttribute(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA, null);
			}
			
			if(objTiempoRequestUltimo!=null){
				Long tiempoRequestUltimo = (Long)objTiempoRequestUltimo;
				tiempoRequestAhora = DateTime.now().getMillis();
				logger.info("DateTimeNow: " + DateTime.now());
				Long tiempoSesionInactivo = tiempoRequestAhora - tiempoRequestUltimo;
				minutosInactividad = tiempoSesionInactivo / Constantes.Fechas.MILISEGUNDOS_POR_MINUTO;
				session.setAttribute(Constantes.Seguridad.TIEMPO_ACTIVIDAD_ULTIMO, tiempoRequestAhora);
			}
			
			if(minutosInactividad >= minutosTimeout){
				usuarioObject = null;
				session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN_SESION_EXPIRADA);
				session.setAttribute(Constantes.Seguridad.MENSAJE_ES_SESION_EXPIRADA, Boolean.TRUE);
				esSesionExpirada = true;
			}
			
		}
		
		esSesionExpirada = esSesionExpirada==null?Boolean.FALSE:esSesionExpirada;
		
		logger.info("Usuario en session: " + usuarioObject);
		logger.info("Minutos de inactividad: " + minutosInactividad);
		
		if (req.getHeader("x-requested-with") != null && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			
			if(usuarioObject == null && !uri.contains("app/login")){
				res.setContentType("application/json; charset=utf-8");
			    PrintWriter out = res.getWriter();
			    String json = "{\"redirect\":\"" + context.getContextPath() + "\"}";
			    out.write(json);
			    out.flush();
			    out.close();
			}else{
				if(esSesionExpirada){
					session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN_SESION_EXPIRADA);
					res.sendRedirect(context.getContextPath());
				}else{
					chain.doFilter(req, res);
				}								
			}
		    
		}else{
			
			if(usuarioObject == null && !uri.contains("/resources") && !uri.contains("/service") && !uri.contains("/VJT")){
				
				if(session!=null){
					if(esSesionExpirada){
						session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN_SESION_EXPIRADA);
					}else{
						session.setAttribute(Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN, Constantes.Seguridad.MENSAJE_INFORMACION_LOGIN_SESION_REQUERIDA);
					}
				}
				
				res.sendRedirect(context.getContextPath());
			}else{
				chain.doFilter(req, res);
			}
			
		}
			
		logger.info("Salio del filtro de autenticacion\n");		
	}

}
