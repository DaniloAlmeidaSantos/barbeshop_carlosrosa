package com.babershopcarlosrosa.service;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;

@Service
public interface ScheduleService {
    boolean insertSchedule(ScheduleDTO schedule);
}
