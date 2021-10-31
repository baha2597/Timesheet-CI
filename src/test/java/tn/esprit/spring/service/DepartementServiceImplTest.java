package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IDepartementService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

@Autowired
IDepartementService dep ;


@Test
public void RetrieveAllDepartements() {
	List<Departement> listDep =dep.retrieveAllDepartements();
	Assert.assertEquals(5,listDep.size());
	
	
}
@Test
public void testAddDepartement()throws ParseException{

	Entreprise e = new Entreprise("esprit","ghazela"); 
	
	Departement d = new Departement(10,"Mahmoud4",null,null,null ); 
	Departement departAdded = dep.addDepartement(d);
	Assert.assertEquals(d.getName(), departAdded.getName());
	
	
}

@Test
public void testUpdateDepartement()throws ParseException{

	
	
	Departement d = new Departement(10,"Mahmoud555555",null,null,null ); 
	Departement departUpdated= dep.updateDepartement(d);
	Assert.assertEquals(d.getName(), departUpdated.getName());
	
}
@Test
public void testRetrieveDepartement() {
	Departement depRetrived = dep.retrieveDepartement(1);
	Assert.assertEquals(1, depRetrived.getId());
}

@Test
public void testDeleteDepartement() {
	dep.deleteDepartement(9);
	Assert.assertNull(dep.retrieveDepartement(9));
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
