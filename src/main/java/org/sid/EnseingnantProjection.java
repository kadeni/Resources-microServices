package org.sid;

import org.sid.entite.Enseignant;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="E1" ,types= {Enseignant.class})
public interface EnseingnantProjection {
public String getNom();
}
