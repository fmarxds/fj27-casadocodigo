package br.com.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Adição no carregamento da servlet base
		return new Class[]{AppWebConfiguration.class, JpaConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Mapeamento padrão de URL que será gerenciado pelo Spring
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// Permite upload de arquivos
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}
