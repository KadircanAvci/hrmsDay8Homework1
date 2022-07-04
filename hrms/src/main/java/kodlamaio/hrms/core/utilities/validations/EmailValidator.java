package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;


public class EmailValidator {
	public static Result valid (String email) {
		
		if(email.isEmpty()) {
			return new ErrorResult("Email alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
	

