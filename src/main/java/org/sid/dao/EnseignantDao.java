package org.sid.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.sid.entite.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
//@RepositoryRestResource

public interface EnseignantDao extends JpaRepository<Enseignant, Long>{
	@Query(value= "select * from enseignant ORDER BY id DESC", nativeQuery = true)
	@Transactional
	public List<Enseignant> findAllByOrderDesc();
	
	@Modifying 
	@Query(value= "update Enseignant e set e.empreinte = :empreinte where e.id =:id", nativeQuery = true)
	@Transactional
	void setEmpreinte (@Param("id") Long id ,@Param("empreinte") String empreinte);
	
	
	@Query(value= "select * from enseignant  where email = :email ", nativeQuery = true)
	@Transactional
	public List<Enseignant> sAuthentifier (@Param("email") String email );
}
