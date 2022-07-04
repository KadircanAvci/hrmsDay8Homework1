package kodlamaio.hrms.core.utilities.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;


public interface EmailVerificationService {
	
	Result verifyEmail(String email);
	
}
