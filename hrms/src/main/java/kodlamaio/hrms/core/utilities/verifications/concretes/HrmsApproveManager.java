package kodlamaio.hrms.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.hrms.entites.concretes.User;

@Service
public class HrmsApproveManager implements HrmsApproveService {

	@Override
	public Result isApproved(User user) {
		
		return new SuccessResult();
	}
	
	
}
