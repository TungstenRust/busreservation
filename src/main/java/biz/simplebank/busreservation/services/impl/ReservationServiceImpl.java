package biz.simplebank.busreservation.services.impl;

import biz.simplebank.busreservation.entities.BusSchedule;
import biz.simplebank.busreservation.entities.Customer;
import biz.simplebank.busreservation.entities.Reservation;
import biz.simplebank.busreservation.models.ReservationApiException;
import biz.simplebank.busreservation.repos.BusScheduleRepository;
import biz.simplebank.busreservation.repos.CustomerRepository;
import biz.simplebank.busreservation.repos.ReservationRepository;
import biz.simplebank.busreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  @Override
  public Reservation addReservation(Reservation reservation) {
    final Customer customer;
    final boolean doesCustomerExist = customerRepository
            .existsByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail());
    if (doesCustomerExist) {
      customer = customerRepository
              .findByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail());
    }
    else{
      customer = customerRepository.save(reservation.getCustomer());
    }
    reservation.setCustomer(customer);
    return reservationRepository.save(reservation);
  }
  @Override
  public List<Reservation> getAllReservations() {return reservationRepository.findAll();}

  @Override
  public List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate) {
    final BusSchedule schedule = busScheduleRepository
            .findById(scheduleId)
            .orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Schedule not found"));
    return reservationRepository.findByBusScheduleAndDepartureDate(schedule, departureDate)
            .orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Reservation not found"));

    }
  @Override
  public List<Reservation> getReservationsByMobile(String mobile) {
    final Customer customer = customerRepository
            .findByMobile(mobile)
            .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "No record found"));
    return reservationRepository.findByCustomer(customer).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Reservation not found"));
  }
}
