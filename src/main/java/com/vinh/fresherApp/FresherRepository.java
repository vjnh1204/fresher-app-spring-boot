package com.vinh.fresherApp;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FresherRepository extends JpaRepository<Fresher, Integer> {

	public List<Fresher> findFresherByName(String name);

	public List<Fresher> findFresherByEmail(String email);

	List<Fresher> findFresherByProgramingLanguage(String programingLanguage);

	@Query(value = "SELECT f.last_score, COUNT(f.fresher_id) FROM tbl_fresher f GROUP BY f.last_score", nativeQuery = true)
	List<Object[]> findGroupByFresherWithScore();
	
	@Query(value = "SELECT f.center_center_id, COUNT(f.fresher_id) FROM tbl_fresher f GROUP BY f.center_center_id", nativeQuery = true)
	List<Object[]> findGroupByFresherWithCenter();
}
