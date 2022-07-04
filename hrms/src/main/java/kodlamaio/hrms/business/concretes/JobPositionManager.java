package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entites.concretes.JobPosition;


@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager (JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "Data listelendi");
				
	}
	public Result isJobPositionExist(String jobPositionName) {
		if(!(this.jobPositionDao.findByJobPositionName(jobPositionName) == null)) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		
		if(!this.isJobPositionExist(jobPosition.getJobPositionName()).isSuccess()) {
			return new ErrorResult("İş pozisyonu sistemde mevcut. Lütfen sistemde bulunmayan bir iş pozisyonu ekleyiniz.");
		}
		
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu sisteme eklendi");
				
	}

	
	
}
