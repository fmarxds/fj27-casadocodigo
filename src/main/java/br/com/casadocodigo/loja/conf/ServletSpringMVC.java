package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Adição no carregamento da servlet base
		return new Class[]{AppWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Mapeamento padrão de URL que será gerenciado pelo Spring
		return new String[] {"/"};
	}

}
