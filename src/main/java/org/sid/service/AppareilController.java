package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AppareilDao;
import org.sid.entite.Appareil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppareilController {
	@Autowired
AppareilDao appareilDao;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/Appareil")
	public List<Appareil> getAppareil()
	{return appareilDao.findAll();}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/SetStatuts/{id}/{statuts}" , method = RequestMethod.GET)
	  public void setStatuts ( @PathVariable("id")Long id ,@PathVariable("statuts")String statuts)
	  {appareilDao.setStatus(id,statuts);
	  }
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/SetValue/{id}/{value}" , method = RequestMethod.GET)
	  public void setValue ( @PathVariable("id")Long id ,@PathVariable("value")String value)
	  {appareilDao.setValue(id,value);
	  }
	

}
