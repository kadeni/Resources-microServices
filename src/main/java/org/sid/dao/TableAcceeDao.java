package org.sid.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entite.TableAccee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TableAcceeDao extends JpaRepository<TableAccee, Long> {
	@Query(value= "select * from tableaccee  ", nativeQuery = true)
	@Transactional
	public List<TableAccee> findByColonne ();
	@Modifying
	@Transactional
	@Query(value = "insert into tableaccee (jour_id, seance_id, enseignant_id) values (:jour, :seance, :enseignant)",
			  nativeQuery = true)
	public void insertTable(@Param("jour") Long jour ,@Param("seance") Long seance,@Param("enseignant") Long enseignant);
}
