package tn.spring.timesheet.services;

import java.util.List;

import tn.spring.timesheet.entities.Employe;

public interface IEmployeService {

	public Employe ajouterEmploye(Employe employe);
	
	public String getEmployePrenomById(int employeId);
	
	public long getNombreEmploye();
	
	public Employe authenticate(String login, String password) ;

	public List<Employe> getEmployes();

	public void deleteEmployeById(int long1);

}
