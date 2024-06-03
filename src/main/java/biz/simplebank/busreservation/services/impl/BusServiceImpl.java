package biz.simplebank.busreservation.services.impl;

import biz.simplebank.busreservation.entities.Bus;
import biz.simplebank.busreservation.repos.BusRepository;
import biz.simplebank.busreservation.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
