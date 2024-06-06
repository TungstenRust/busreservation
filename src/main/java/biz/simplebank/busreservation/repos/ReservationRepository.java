package biz.simplebank.busreservation.repos;

import biz.simplebank.busreservation.entities.BusSchedule;
import biz.simplebank.busreservation.entities.Customer;
import biz.simplebank.busreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<List<Reservation>> findByCustomer(Customer customer);

    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate);
}
