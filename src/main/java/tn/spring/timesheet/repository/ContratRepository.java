package tn.spring.timesheet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.timesheet.entities.Contrat;


@Repository
public interface ContratRepository extends CrudRepository<Contrat , Integer>{

}
