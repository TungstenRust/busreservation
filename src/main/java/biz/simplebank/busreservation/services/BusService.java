package biz.simplebank.busreservation.services;

import biz.simplebank.busreservation.entities.Bus;

import java.util.List;

public interface BusService {
   Bus addBus(Bus bus);

   List<Bus> getAllBus();

}
