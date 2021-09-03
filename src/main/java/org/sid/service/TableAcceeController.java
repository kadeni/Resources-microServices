package org.sid.service;

import java.util.List;

import org.sid.dao.TableAcceeDao;
import org.sid.entite.Enseignant;
import org.sid.entite.TableAccee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableAcceeController {
	@Autowired
private TableAcceeDao tableAcceeDao;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allTableAccee")
	  public List<TableAccee>  ListeTableAccee()
		  {return tableAcceeDao.findByColonne();}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/ajouterTableAccee")
	public TableAccee ajouterEnseingnant(@RequestBody TableAccee e)
	{return tableAcceeDao.save(e);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/ajouterTableAccee/{jour}/{seance}/{enseignant}")
	public List<TableAccee>  ajouterTableAccee(@PathVariable("jour")Long jour,@PathVariable("seance") Long seance,@PathVariable("enseignant") Long enseignant)
	{ tableAcceeDao.insertTable(jour, seance, enseignant);
	return tableAcceeDao.findByColonne();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/deleteTableAccee/{id}")
	public List<TableAccee> delete(@PathVariable(value = "id")Long id)
	{tableAcceeDao.deleteById(id);
	return tableAcceeDao.findByColonne();
	}
	
	
	
	
	
	
	
	
}
