package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.JobSeekers;

public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer> {
	
		JobSeekers findByEmail(String email);
		JobSeekers findByIdentificationNumber(String identificationNumber);
	
}
