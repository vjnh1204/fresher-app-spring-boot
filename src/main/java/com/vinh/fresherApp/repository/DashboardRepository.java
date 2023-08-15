package com.vinh.fresherApp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vinh.fresherApp.entity.Fresher;

public interface DashboardRepository extends JpaRepository<Fresher, Integer> {
	
	

}
