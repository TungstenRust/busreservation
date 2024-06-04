package biz.simplebank.busreservation.repos;

import biz.simplebank.busreservation.entities.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRouteRepository extends JpaRepository <BusRoute, Long> {
    Optional<BusRoute> findBusRouteName(String routeName);
    Optional<BusRoute> findBusCityFromAndCityTo(String cityFrom, String cityTo);

}
