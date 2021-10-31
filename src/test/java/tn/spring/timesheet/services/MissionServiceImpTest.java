package tn.spring.timesheet.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.spring.timesheet.entities.Mission;
import tn.spring.timesheet.repository.IMissionRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImpTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(MissionServiceImpTest.class);

	
	
	
	@Autowired
	IMissionRepository Mr ;
	
	@Autowired
	IMissionService Ms ;
	
	
	
	//Add Mission Test 
		@Test
		public void testaddMission() {
			Mission mission = new Mission("missionTest","missionTest");
		Ms.ajouterMission(mission);
		assertNotNull(mission.getId());
		l.info("Mission added successfuly ");
		Mr.delete(mission);
		}

		
		
		
	
	
}
