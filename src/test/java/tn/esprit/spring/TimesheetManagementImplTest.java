package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetManagementImplTest {

	private static final Logger l = LogManager.getLogger();

	@Autowired
    private EntrepriseServiceImpl	entSer;
	@Autowired
	private EntrepriseRepository repo;
	@Autowired
	private DepartementRepository repoD;
	
	@Test
	public void testCreateEntreprise(){
		Entreprise ent= new Entreprise("SAB" , "SA");
		
		int id = entSer.ajouterEntreprise(ent);
		assertNotNull((Integer)id);
		l.debug("les noms de departements:"  + id );
	}

	
//	@Test
//	public void testCreateDepartement(){
//		Departement dep= new Departement("Droit");
//		int id = entSer.ajouterDepartement(dep);
//		assertNotNull((Integer)id);
//	}
//	
//	@Test
//	public void affecterDepartementAEntreprise(){
//		int depId = 21;
//		int entrepriseId = 7;
//		entSer.affecterDepartementAEntreprise(depId,entrepriseId);
//		assertNotNull((Integer)entrepriseId);
//	}
//	@Test
//	public void getAllDepartementsNamesByEntreprise(){
//		int entrepriseId = 7;
//		List<String>  listDep = entSer.getAllDepartementsNamesByEntreprise(entrepriseId);
//		 for(String str:listDep){
//				l.debug("les noms de departements:"  + str );
//			
//		 }
//		 assertThat(listDep).size().isPositive();
//		
//	}
//	@Test
//	public void getEntrepriseById(){
//		int entrepriseId = 7;
//		Entreprise ent = entSer.getEntrepriseById(entrepriseId);
//		assertThat(ent.getId()).isEqualTo(entrepriseId);
//			l.debug("le nom de l'entreprise:"  + ent.getName() );
//	}
//	@Test
//	public void deleteEntrepriseById(){
//		int entrepriseId = 24;
//		boolean isExist = repo.findById(entrepriseId).isPresent();
//		 entSer.deleteEntrepriseById(entrepriseId);		
//		 
//		 boolean notExist = repo.findById(entrepriseId).isPresent();
//		 assertTrue(isExist);
//		 assertFalse(notExist);
//
//	}
//	
//	@Test
//	public void deleteDepartementById(){
//		int entrepriseId = 19;
//		boolean isExist = repoD.findById(entrepriseId).isPresent();
//		 entSer.deleteDepartementById(entrepriseId);			 
//		 
//		 boolean notExist = repoD.findById(entrepriseId).isPresent();
//		 assertTrue(isExist);
//		 assertFalse(notExist);
//	}
	
}
