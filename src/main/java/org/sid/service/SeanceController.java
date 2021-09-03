package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.SeanceDao;

import org.sid.entite.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeanceController {
	@Autowired
	SeanceDao seanceDao;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/Seance/{id}")
	public Optional<Seance> getSeanceId(@PathVariable(value = "id")Long id)
	{
	return seanceDao.findById(id);}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(value = "/getSeance/{debut}" , method = RequestMethod.GET)
	public List<Seance> seancePardebut(@PathVariable("debut") String debut )
	{return seanceDao.seanceParDebut(debut);}
}
