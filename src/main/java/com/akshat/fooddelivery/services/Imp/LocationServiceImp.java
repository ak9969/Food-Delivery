package com.akshat.fooddelivery.services.Imp;

import com.akshat.fooddelivery.model.Location;
import com.akshat.fooddelivery.repository.LocationRepository;
import com.akshat.fooddelivery.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location updateLocation(Long id, Location location) {
        Optional<Location> getLocation = locationRepository.findById(id);
        Location updatedLocation = null;
        if(getLocation.isPresent()){
            updatedLocation = getLocation.get();
            updatedLocation.setLocationId(location.getLocationId());
            updatedLocation.setLocationName(location.getLocationName());
        }
        return updatedLocation;
    }
}
