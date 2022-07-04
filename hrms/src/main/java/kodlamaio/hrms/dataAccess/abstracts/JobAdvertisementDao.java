package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
		
	@Query("Select new kodlamaio.hrms.entites.dtos.JobAdvertisementDto(ja.id,e.companyName,jp.jobPositionName,ja.numberOfOpenPositions,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobPosition jp where ja.isActive =true")
		List<JobAdvertisementDto> getByJobAdvertisementIsActive();
	
	@Query("Select new kodlamaio.hrms.entites.dtos.JobAdvertisementDto(ja.id,e.companyName,jp.jobPositionName,ja.numberOfOpenPositions,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobPosition jp where ja.isActive =true and e.companyName =:companyName")
	List<JobAdvertisementDto> getByJobAdvertisementWithCompanyNameAndIsActive(String companyName);
	
	@Query("Select new kodlamaio.hrms.entites.dtos.JobAdvertisementDto(ja.id,e.companyName,jp.jobPositionName,ja.numberOfOpenPositions,ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobPosition jp where ja.isActive =true order by ja.applicationDeadline desc")
	List<JobAdvertisementDto> getByJobAdvertisementWithApplicationDeadlineAndIsActive();
	
	JobAdvertisement getById(int jobAdvertisementId);
	
	
}
