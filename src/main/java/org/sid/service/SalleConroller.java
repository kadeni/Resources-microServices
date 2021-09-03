package org.sid.service;

import java.util.List;

import org.sid.dao.SalleDao;
import org.sid.entite.Enseignant;
import org.sid.entite.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalleConroller {
	@Autowired
	SalleDao salleDao ;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allSalle")
	  public List<Salle>  ListeSalle()
		  {return salleDao.findAll();}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/ajouterSalle")
	public Salle ajouterSalle(@RequestBody Salle s)
	{return salleDao.save(s);}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/deleteSalle/{id}")
	public List<Salle> delete(@PathVariable(value = "id")Long id)
	{salleDao.deleteById(id);
	return salleDao.findAll();
	}
	
	

}
