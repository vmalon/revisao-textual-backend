package com.ifg.revisaotextual.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ifg.revisaotextual.entities.Revisao;
import com.ifg.revisaotextual.entities.ServicoValor;

@Configuration
public class ReadOnlyRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] unsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

		// Disabilita os métodos HTTTP PUT, POST e DELETE para Product
		config.getExposureConfiguration().forDomainType(Revisao.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));

		// Disabilita os métodos HTTTP PUT, POST e DELETE para ProductCategory
		config.getExposureConfiguration().forDomainType(ServicoValor.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));
		cors.addMapping("/**").allowedOrigins("http://localhost:3000");

	}
}