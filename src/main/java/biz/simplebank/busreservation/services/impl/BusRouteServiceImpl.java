package biz.simplebank.busreservation.services.impl;

import biz.simplebank.busreservation.entities.BusRoute;
import biz.simplebank.busreservation.models.ReservationApiException;
import biz.simplebank.busreservation.repos.BusRouteRepository;
import biz.simplebank.busreservation.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Autowired
    private BusRouteRepository busRouteRepository;
    @Override
    public BusRoute addRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findBusRouteName(routeName)
                .orElseThrow(() ->
                        new ReservationApiException(HttpStatus.BAD_REQUEST,
                                "No such Route found"));
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findBusCityFromAndCityTo(cityFrom, cityTo)                .orElseThrow(() ->
                new ReservationApiException(HttpStatus.BAD_REQUEST,
                        "No such Route found"));
    }
}
