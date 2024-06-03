package biz.simplebank.busreservation.repos;

import biz.simplebank.busreservation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
