package kodlamaio.hrms.core.utilities.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.User;

public interface HrmsApproveService {
	
	Result isApproved(User user);
	
	
}
