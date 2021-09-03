package org.sid;


import org.sid.entite.Enseignant;
import org.sid.entite.Jour;
import org.sid.entite.Salle;
import org.sid.entite.Seance;
import org.sid.entite.TableAccee;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration)
	{repositoryRestConfiguration.setReturnBodyOnCreate(true);
	repositoryRestConfiguration.setReturnBodyOnUpdate(true);
	repositoryRestConfiguration.exposeIdsFor(Enseignant.class);
	repositoryRestConfiguration.exposeIdsFor(Salle.class);
	repositoryRestConfiguration.exposeIdsFor(Jour.class);
	repositoryRestConfiguration.exposeIdsFor(Seance.class);
	repositoryRestConfiguration.exposeIdsFor(TableAccee.class);

	repositoryRestConfiguration.getCorsRegistry().addMapping("/**")
	.allowedOrigins("*")
	.allowedHeaders("*")
	.allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
	
		
		
		
		
	}

}
