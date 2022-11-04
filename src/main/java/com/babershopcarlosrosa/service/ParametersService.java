package com.babershopcarlosrosa.service;

import com.babershopcarlosrosa.model.dto.SchedulingDTO;

public interface ParametersService {
    boolean searchByTime(SchedulingDTO parameters);

    boolean introduceTime(SchedulingDTO parameters);
}
