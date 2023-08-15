package com.vinh.fresherApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinh.fresherApp.entity.CompanyCenter;
import com.vinh.fresherApp.entity.FresherCenterReport;
import com.vinh.fresherApp.entity.FresherReportScore;
import com.vinh.fresherApp.repository.CenterRepository;
import com.vinh.fresherApp.repository.FresherRepository;

@RestController
public class DashboardController {
	private FresherRepository fresherRepository;
	private CenterRepository centerRepository;
	public DashboardController(FresherRepository fresherRepository,CenterRepository centerRepository) {
		super();
		this.fresherRepository = fresherRepository;
		this.centerRepository = centerRepository;
	}
	
	@GetMapping("api/dashboard/scores")
	public List<FresherReportScore> getFresherReportScore(){
		List<Object[]> result = fresherRepository.findGroupByFresherWithScore();
		List<FresherReportScore> fresherReportScores = new ArrayList<>();
		for(Object[] o: result) {
			fresherReportScores.add(new FresherReportScore((Float)o[0],(Long)o[1]));
		}
		
		return fresherReportScores;
	}
	
	@GetMapping("api/dashboard/centers")
	public List<FresherCenterReport> getFresherReportCenter(){
		List<Object[]> result = fresherRepository.findGroupByFresherWithCenter();
		List<FresherCenterReport> fresherCenterReports = new ArrayList<>();
		
		for(Object[] o : result) {
			Optional<CompanyCenter> center = null;
			String centerName ;
			if(o[0] != null) {
				center = centerRepository.findById((Integer)o[0]);
				centerName = center.get().getName();
			}
			else {
				centerName = "Fresher chua vao center";
			}
			
			fresherCenterReports.add(new FresherCenterReport(centerName, (Long)o[1]));
		}
		return fresherCenterReports;
	}
	
}
