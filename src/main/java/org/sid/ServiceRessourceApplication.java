package org.sid;


import org.sid.dao.AppareilDao;
import org.sid.dao.EnseignantDao;
import org.sid.dao.JourDao;
import org.sid.dao.SalleDao;
import org.sid.dao.SeanceDao;
import org.sid.dao.TableAcceeDao;
import org.sid.entite.Appareil;
import org.sid.entite.Enseignant;
import org.sid.entite.Jour;
import org.sid.entite.Salle;
import org.sid.entite.Seance;
import org.sid.entite.TableAccee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//implements CommandLineRunner

@SpringBootApplication
public class ServiceRessourceApplication  {
	@Autowired
    private EnseignantDao enseignantDao ;
	@Autowired
    private JourDao jourDao;
	@Autowired
   private  SalleDao salleDao; 
	@Autowired
    private SeanceDao seanceDao;
	@Autowired
    private TableAcceeDao tableAcceeDao;
	@Autowired
	private AppareilDao appareilDao;

	
	public static void main(String[] args) {
		SpringApplication.run(ServiceRessourceApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub appareilDao.save(new Appareil(null ,
	 * "Lampe","automatique",0)); appareilDao.save(new Appareil(null ,
	 * "Climatiseur","automatique",0)); appareilDao.save(new Appareil(null ,
	 * "DataShow","allumé", 0));
	 * 
	 * Enseignant e1=enseignantDao.save(new
	 * Enseignant(null,"Sehili","Ines","noussa.guit@gmail.com","0123","0561144115",
	 * "nonEnregistrer" )); Enseignant e2=enseignantDao.save(new
	 * Enseignant(null,"Gourari","Aya","aya.Gourari@gmail.com","01445","05616040",
	 * "Enregistrer" )); Enseignant e3=enseignantDao.save(new
	 * Enseignant(null,"Ali","Ali","Ali.Ali@gmail.com","0124453","0561199788",
	 * "nonEnregistrer"));
	 * 
	 * 
	 * Jour j1=jourDao.save(new Jour(null,"sam")); Jour j2=jourDao.save(new
	 * Jour(null,"dim")); Jour j3=jourDao.save(new Jour(null,"lun")); Jour
	 * j4=jourDao.save(new Jour(null,"mar")); Jour j5=jourDao.save(new
	 * Jour(null,"mer")); Jour j6=jourDao.save(new Jour(null,"jeu")); Jour
	 * j7=jourDao.save(new Jour(null,"ven")); Seance s1=seanceDao.save(new
	 * Seance(null,"08:30","10:00")); Seance s2=seanceDao.save(new
	 * Seance(null,"10:00","11:30")); Seance s3=seanceDao.save(new
	 * Seance(null,"11:30","13:00")); Seance s4=seanceDao.save(new
	 * Seance(null,"13:00","14:30")); Seance s5=seanceDao.save(new
	 * Seance(null,"14:30","16:00")); Salle salle1=salleDao.save( new
	 * Salle(1L,"premier","nonlibre","Amphy")); Salle salle2=salleDao.save(new
	 * Salle(2L,"premier","libre","salle TD")); Salle salle3=salleDao.save(new
	 * Salle(3L,"premier","libre","salle TP")); //le dimanche ,de 08:30 a 10:00 //
	 * l'enseignant Sehili Ines aura cour a la salle 1 TableAccee
	 * t1=tableAcceeDao.save(new TableAccee(null,j1,s3,e3,salle1));
	 * 
	 * 
	 * 
	 * }
	 */

}
