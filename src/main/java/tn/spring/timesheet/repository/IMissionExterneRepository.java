package tn.spring.timesheet.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.spring.timesheet.entities.MissionExterne;

@Repository
public interface IMissionExterneRepository  extends CrudRepository<MissionExterne,Long>{

}
