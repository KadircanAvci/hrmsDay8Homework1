package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class FirstNameValidator {
	
	public static Result valid (String firstName) {
		
		if(firstName.isEmpty()) {
			return new ErrorResult("İsim alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
