package tn.spring.timesheet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.services.IContratService;

@RestController
public class ContratRestController {

	@Autowired
	IContratService icontratService;

	@PostMapping("/ajouterContrat")
	@ResponseBody
	public Contrat ajouterContrat(@RequestBody Contrat contrat) {
		icontratService.ajouterContrat(contrat);
		return contrat;
	}
	@DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		icontratService.deleteContratById(contratId);
	}
}
