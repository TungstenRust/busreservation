package biz.simplebank.busreservation.controller;

import biz.simplebank.busreservation.entities.Reservation;
import biz.simplebank.busreservation.models.ResponseModel;
import biz.simplebank.busreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseModel<Reservation>addReservation(@RequestBody Reservation reservation){
        final Reservation result = reservationService.addReservation(reservation);
        return new ResponseModel<>(HttpStatus.OK.value(), "Reservation saved", result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>>getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/query")
    public ResponseEntity<List<Reservation>>getReservationsByScheduleAndDepartureDate(
        @RequestParam Long scheduleId,
        @RequestParam String departureDate
        ){
        return ResponseEntity.ok(reservationService.getReservationsByScheduleAndDepartureDate(scheduleId, departureDate));
    }

    @GetMapping("/all/{mobile}")
    public ResponseEntity<List<Reservation>> getReservationsByMobile(
            @PathVariable(name = "mobile") String mobile
        )
        {
            return ResponseEntity.ok(reservationService.getReservationsByMobile(mobile));
    }
}
