package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;


@RestController
@RequestMapping("/api/jobadvirtisements")
public class JobAdvertisementControllers {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementControllers(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
 	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping("/getByJobAdvertisementIsActive")
		public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementIsActive(){
		return this.jobAdvertisementService.getByJobAdvertisementIsActive();
	}
	@GetMapping("/getByJobAdvertisementWithCompanyNameAndIsActive")	
	public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithCompanyNameAndIsActive(String companyName) {
		return this.jobAdvertisementService.getByJobAdvertisementWithCompanyNameAndIsActive(companyName);
	}
	@GetMapping("/getByJobAdvertisementWithApplicationDeadlineAndIsActive")
	public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithApplicationDeadlineAndIsActive(){
		return this.jobAdvertisementService.getByJobAdvertisementWithApplicationDeadlineAndIsActive();
	}
	@PostMapping("/inactive")
	public 	Result inactive(int jobAdvertisementId) {
		return this.jobAdvertisementService.inactive(jobAdvertisementId);
	}
	
	
}
