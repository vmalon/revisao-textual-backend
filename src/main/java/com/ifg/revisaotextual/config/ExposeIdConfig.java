package com.ifg.revisaotextual.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ExposeIdConfig implements RepositoryRestConfigurer {
 private EntityManager entityManager;
 @Autowired
 
 public ExposeIdConfig(EntityManager entityManager) {
 this.entityManager = entityManager;
 }
 
 @Override
 public void configureRepositoryRestConfiguration(RepositoryRestConfiguration
	config, CorsRegistry cors) {
	 Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
	 List<Class<?>> entityClasses = new ArrayList<>();
	 for (EntityType<?> entityType: entities) {
	 entityClasses.add(entityType.getJavaType());
	 }
	 Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
	 config.exposeIdsFor(domainTypes);
 }
 
}