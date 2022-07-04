package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class IdentificationNumberValidator {
	public static Result valid (String identificationNumber) {
		
		if(identificationNumber.isEmpty()) {
			return new ErrorResult("T.C. kimlik alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
