package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementDto>> getByJobAdvertisementIsActive();
	DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithCompanyNameAndIsActive(String companyName);
	DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithApplicationDeadlineAndIsActive();
	Result inactive(int jobAdvertisementId);
}
