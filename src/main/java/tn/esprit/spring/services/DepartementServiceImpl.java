package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service

public class DepartementServiceImpl implements IDepartementService {
	@Autowired
	DepartementRepository dRepo;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> Departements = null;
		try {

			l.info("In retrieveAllDepartements() : ");
			Departements = (List<Departement>) dRepo.findAll();
			for (Departement Departement : Departements) {
				l.debug("Departement +++ : " + Departement);
			}
			l.info("Out of retrieveAllDepartements() : ");
		} catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return Departements;
	}

	public Departement addDepartement(Departement d) {
		if(d.getName()=="Mahmoud") 
			l.error("hbiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiib");
		return dRepo.save(d);

	}

	public Departement updateDepartement(Departement d) {
		
			

		return dRepo.save(d);
	}

	@Override
	public void deleteDepartement(int id) {
		dRepo.deleteById(id);

	}

	@Override
	public Departement retrieveDepartement(int id) {
		l.info("in  retrieveDepartement id = " + id);
		// Departement u =
		// DepartementRepository.findById(Long.parseLong(id)).orElse(null);
		// int i = 1/0;
		Departement d = dRepo.findById(id).orElse(null);
		l.info("Departement returned : " + d);
		return d;
	}

}
