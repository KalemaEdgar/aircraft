package com.home.aircraft.Repositories;

import com.home.aircraft.Models.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface PlaneRepository extends CrudRepository<Aircraft, Long> {
}
