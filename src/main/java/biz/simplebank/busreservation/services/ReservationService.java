package biz.simplebank.busreservation.services;

import biz.simplebank.busreservation.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate);
    List<Reservation> getReservationsByMobile(String mobile);
}
