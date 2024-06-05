package biz.simplebank.busreservation.services;

import biz.simplebank.busreservation.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    BusSchedule addSchedule(BusSchedule busSchedule);
    List<BusSchedule> getAllBusSchedules();
    List<BusSchedule> getSchedulesByRoute(String routeName);
}
