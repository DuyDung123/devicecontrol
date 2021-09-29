package com.laptrinhjavaweb.devicecontrol.service.impl;

import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;
import com.laptrinhjavaweb.devicecontrol.repository.StatusRepository;
import com.laptrinhjavaweb.devicecontrol.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusService implements IStatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public StatusDTO save(StatusDTO statusDTO) {
        return null;
    }
}
