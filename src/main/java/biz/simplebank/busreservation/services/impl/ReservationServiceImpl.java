package biz.simplebank.busreservation.services.impl;

import biz.simplebank.busreservation.entities.Reservation;
import biz.simplebank.busreservation.repos.BusScheduleRepository;
import biz.simplebank.busreservation.repos.CustomerRepository;
import biz.simplebank.busreservation.repos.ReservationRepository;
import biz.simplebank.busreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
  @Autowired
    private ReservationRepository reservationRepository;
  @Autowired
    private CustomerRepository customerRepository;
  @Autowired
    private BusScheduleRepository busScheduleRepository;

}
