package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entites.concretes.JobAdvertisement;
import kodlamaio.hrms.entites.dtos.JobAdvertisementDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
	}
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}



	@Override
	public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByJobAdvertisementIsActive(), "Data listelendi");
	}



	@Override
	public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithCompanyNameAndIsActive(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByJobAdvertisementWithCompanyNameAndIsActive(companyName));
	}



	@Override
	public DataResult<List<JobAdvertisementDto>> getByJobAdvertisementWithApplicationDeadlineAndIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByJobAdvertisementWithApplicationDeadlineAndIsActive());
	}



	@Override
	public Result inactive(int jobAdvertisementId){
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
		if(jobAdvertisement != null) {
			jobAdvertisement.setActive(false);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İş ilanı pasif yapıldı");
		}
		
		return new ErrorResult("Böyle bir ilan bulunamadı.");
	}








	

}
