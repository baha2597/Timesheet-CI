package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.entities.Entreprise;

import java.util.List;

@Repository
public interface IEmployeRepository extends CrudRepository<Employe,Long>{
	
	@Query("SELECT e.nom FROM Employe e")
	List<String> getAllEmployeNamesJPQL();

	@Query("SELECT count(e) FROM Employe e")
	Long getNombreEmployeJPQL();

	@Query("Select "
			+ "DISTINCT e from Employe e "
			+ "join e.departements dep "
			+ "join dep.entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Employe> getAllEmployeByEntreprise(@Param("entreprise") Entreprise entreprise);
	

	@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password =:password")
	public Employe getEmployeByEmailAndPassword(
	@Param("email")String login,
	@Param("password")String password);
}
