package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.JourDao;
import org.sid.entite.Jour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JourController {
	@Autowired
JourDao jourDao;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/Jour/{id}")
	public Optional<Jour> getSeanceId(@PathVariable(value = "id")Long id)
	{
	return jourDao.findById(id);}
	@CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(value = "/getJour/{name}" , method = RequestMethod.GET)
	public List<Jour> jourParJour(@PathVariable("name") String name )
	{return jourDao.JourParJour(name);}
}
