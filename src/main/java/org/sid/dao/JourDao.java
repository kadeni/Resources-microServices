package org.sid.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.sid.entite.Jour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource
public interface JourDao extends JpaRepository<Jour, Long> {
	@Query(value= "select * from jour  where name = :name ", nativeQuery = true)
	@Transactional
	public List<Jour> JourParJour (@Param("name") String name );
}
