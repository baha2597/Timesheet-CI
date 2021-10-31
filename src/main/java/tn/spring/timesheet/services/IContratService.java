package tn.spring.timesheet.services;
import org.springframework.stereotype.Repository;

import tn.spring.timesheet.entities.Contrat;

@Repository
public interface IContratService {

	public Contrat ajouterContrat(Contrat contrat);
	public void deleteContratById(int ContratId );
}
