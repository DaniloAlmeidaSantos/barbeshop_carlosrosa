package com.babershopcarlosrosa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.model.dto.ScheduledDTO;

@Service
public interface ScheduleService {
    boolean insertSchedule(ScheduleDTO schedule);
    List<ScheduledDTO> getServicesScheduled(long userId);
}
