package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
