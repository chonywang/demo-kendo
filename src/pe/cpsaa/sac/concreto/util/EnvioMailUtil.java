package pe.cpsaa.sac.concreto.util;

import java.io.File;
import java.util.List;

import pe.cpsaa.common.mailing.bean.MailBean;
import pe.cpsaa.common.mailing.config.MailConfig;
import pe.cpsaa.common.mailing.constantes.ConstantesMail;
import pe.cpsaa.common.mailing.util.MailUtil;

public class EnvioMailUtil {

	public static Object getMailConfig(String user, String pswd, String host, String timeout){
		
		MailConfig mailCfg = new MailConfig();	
		mailCfg.setUser(user);
		mailCfg.setPswd(pswd);
		mailCfg.setMailTransportProtocol(Constantes.SISTEMA_MAIL_TRANS_PROTOCOL);
		mailCfg.setTransportProtocol(Constantes.SISTEMA_TRANS_PROTOCOL);		
		mailCfg.setMailTransportHost(Constantes.SISTEMA_MAIL_TRANS_HOST);
		mailCfg.setTransportHost(host);
		mailCfg.setMailTransportAuth(Constantes.SISTEMA_MAIL_TRANS_AUTH);
		mailCfg.setAuthorization(true);
		
		mailCfg.setContentType(ConstantesMail.CONTENT_TYPE_HTML);
		mailCfg.setMailConnectionTimeout(Constantes.SISTEMA_MAIL_CONN_TIMEOUT);
		mailCfg.setMailTimeout(Constantes.SISTEMA_MAIL_TIMEOUT);
		mailCfg.setConnectionTimeout(timeout);
		mailCfg.setTimeout(timeout);
		
		return (Object) mailCfg;
	}
	
	public static Object getMailBean(String from, String to, String cc, String bcc, String subject, String mensaje, List<File> archivos){
			
		MailBean mailBean = new MailBean();
		
		mailBean.setFrom(from);
		mailBean.setTo(to);
		mailBean.setSubject(subject);
		mailBean.setToCC(cc!=null?cc:"");
		mailBean.setToBCC(bcc!=null?bcc:"");
		mailBean.setText(mensaje);
		mailBean.setFilesAttach(archivos);		
		
		return (Object) mailBean;
	}
	
	public static void sendMail(Object bean, Object cfg) throws Exception{
		
		MailBean mailBean = (MailBean) bean;
		MailConfig mailCfg = (MailConfig) cfg;
		
		MailUtil.send(mailBean,mailCfg);
	}
	
}
