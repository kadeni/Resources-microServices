package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.EnseignantDao;
import org.sid.entite.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Empreinte.JArduino;
import Empreinte.JArduinoControle;



@RestController
public class EnseignantController {
	@Autowired
EnseignantDao enseignantDao;
	JArduinoControle arduino = new JArduino("COM4");
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allEnseignant")
	  public List<Enseignant>  ListeEnseignant()
		  {return enseignantDao.findAllByOrderDesc();}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/ajouterEnseignant")
	public Enseignant ajouterEnseingnant(@RequestBody Enseignant e)
	{return enseignantDao.save(e);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getEnseignant/{id}")
	public Optional<Enseignant> getEnseignantId(@PathVariable(value = "id")Long id)
	{return enseignantDao.findById(id);}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/enregisterEmpreinte/{id}")
	public void enregistrerEmpreinte(@PathVariable(value = "id")int id)
	{   
		arduino.envoyerIdEmpreinte(id);
	}
	@GetMapping(value = "/stopEnregistrement")
	public void stopEnregistrerEmpreinte(@PathVariable(value = "id")int id)
	{   
		arduino.simpleMeth();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/recupererIdEmpreinte")
	public int recupererIdEmpreinte()
	{  int retour=arduino.recupererIdEmpreinte();
	System.out.println(retour);
	//arduino.simpleMeth();
	return retour;}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/deleteEnseingant/{id}")
	public List<Enseignant> delete(@PathVariable(value = "id")Long id)
	{enseignantDao.deleteById(id);
	return enseignantDao.findAllByOrderDesc();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(value = "/SetEmpreinte/{id}/{empreinte}" , method = RequestMethod.GET)
	 public Optional<Enseignant> setEmpreinte(@PathVariable("id") Long id ,@PathVariable("empreinte") String empreinte)
	{enseignantDao.setEmpreinte(id, empreinte);
	return enseignantDao.findById(id);}
	
	@CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(value = "/sAuthentifier/{email}" , method = RequestMethod.GET)
	public List<Enseignant> sAuthentifier(@PathVariable("email") String email )
	{return enseignantDao.sAuthentifier(email);}
	
	
	
}
