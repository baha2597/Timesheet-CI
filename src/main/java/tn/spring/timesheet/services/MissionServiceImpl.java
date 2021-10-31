package tn.spring.timesheet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.timesheet.entities.Mission;
import tn.spring.timesheet.repository.IMissionRepository;

import java.util.List;

@Service
public class MissionServiceImpl implements IMissionService {
	

	
	@Autowired
	IMissionRepository mr ;
	
	
	
	
	
	@Override
	public List<Mission> getMissions() {
		return (List<Mission>) mr.findAll();
	}
	
	@Override
	public long ajouterMission(Mission mission) {
		mr.save(mission);
		return new Long(mission.getId());
	}
	
	
	@Override
	public long getMissionNumber() {
		return mr.count();
	}
	
	
	
	@Override
	public Mission MissionUpadate(Mission Miss) {
		
		Mission existingMiss=mr.findById(new Long(Miss.getId())).orElse(null);
		
		mr.findById(new Long(Miss.getId()));
		existingMiss.setName(Miss.getName());
		existingMiss.setDescription(Miss.getDescription());
		
		return mr.save(existingMiss);
	}
	

	@Override
	public void deleteMission(int id) {
		mr.deleteById((long)id);

	}
	
	
	
	

}
