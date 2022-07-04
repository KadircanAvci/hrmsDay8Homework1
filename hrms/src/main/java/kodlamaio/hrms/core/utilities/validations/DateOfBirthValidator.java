package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class DateOfBirthValidator {
	public static Result valid (String dateOfBirth) {
		
		if(dateOfBirth.isEmpty()) {
			return new ErrorResult("Daoğum tarihi alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
