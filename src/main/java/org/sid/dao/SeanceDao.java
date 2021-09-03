package org.sid.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entite.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource
public interface SeanceDao extends JpaRepository<Seance, Long> {
	@Query(value= "select * from seance  where debut = :debut ", nativeQuery = true)
	@Transactional
	public List<Seance> seanceParDebut (@Param("debut") String debut );
}
