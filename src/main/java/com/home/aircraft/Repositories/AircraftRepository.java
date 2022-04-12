package com.home.aircraft.Repositories;

import com.home.aircraft.Models.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
}
