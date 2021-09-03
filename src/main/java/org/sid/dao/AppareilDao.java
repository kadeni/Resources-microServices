package org.sid.dao;

import javax.transaction.Transactional;

import org.sid.entite.Appareil;
import org.sid.entite.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppareilDao  extends JpaRepository<Appareil, Long>{
	@Modifying 
	@Query(value= "update Appareil a set a.status = :status where a.id =:id", nativeQuery = true)
	@Transactional
	void setStatus (@Param("id") Long id ,@Param("status") String status);
	@Modifying 
	@Query(value= "update Appareil a set a.value = :value where a.id =:id", nativeQuery = true)
	@Transactional
	void setValue (@Param("id") Long id ,@Param("value") String status);
}
