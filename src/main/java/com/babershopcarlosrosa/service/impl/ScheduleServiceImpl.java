package com.babershopcarlosrosa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.model.dto.ScheduledDTO;
import com.babershopcarlosrosa.repository.ScheduleRepository;
import com.babershopcarlosrosa.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    private ScheduleRepository skdRepository;
    
    @Autowired
    private AdministratorServiceImpl administratorServiceImpl;
    
    @Override
    public boolean insertSchedule(ScheduleDTO schedule) {
        try {
            if(!skdRepository.searchByDateTime(schedule)) {
                return skdRepository.insertScheduling(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

	@Override
	public List<ScheduledDTO> getServicesScheduled(long userId){
		boolean isAdmin = administratorServiceImpl.isAdministrator(userId);
		
		if (isAdmin) {
			log.info("[ INPUT - GET SERVICES SCHEDULED ] Searching scheduling services to Administrator");
			return skdRepository.getJobsScheduledToAdmin();
		} else {
			log.info("[ INPUT - GET SERVICES SCHEDULED ] Searching scheduling services to Customer");
			return skdRepository.getJobsScheduledToCustomer(userId);
		}
	}

	@Override
	public boolean updateStatus(String indentifications) {
		
		String[] indentifys = indentifications.split(",");
		
		for (String indentify : indentifys) {
			
			boolean isUpdated = skdRepository.updateStatus(Integer.parseInt(indentify));
			
			if (!isUpdated) {
				return false;
			}
			
		}
		
		return true;
	}
    
    
}
