package tn.spring.timesheet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.repository.ContratRepository;

@Transactional
@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;

	@Override
	public Contrat ajouterContrat(Contrat contrat) {
	
		contratRepository.save(contrat);
		
		return contrat;
	}

	@Override
	public void deleteContratById(int ContratId) {

		Contrat contratManagedentity = contratRepository.findById(ContratId).get();
		contratRepository.delete(contratManagedentity);
	}

}
