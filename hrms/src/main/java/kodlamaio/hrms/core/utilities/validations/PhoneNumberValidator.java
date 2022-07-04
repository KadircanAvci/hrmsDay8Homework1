package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class PhoneNumberValidator {
	public static Result valid (String phoneNumber) {
		
		if(phoneNumber.isEmpty()) {
			return new ErrorResult("İsim alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
