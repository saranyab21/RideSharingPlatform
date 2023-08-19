package com.rideManagement.DAL;
import com.rideManagement.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rideManagement.model.Distance;

public interface RideRepos2 extends JpaRepository<Distance, Integer>{

}
