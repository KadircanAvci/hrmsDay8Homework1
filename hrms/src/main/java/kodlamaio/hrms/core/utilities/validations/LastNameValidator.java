package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class LastNameValidator {

	public static Result valid (String lastName) {
		
		if(lastName.isEmpty()) {
			return new ErrorResult("Soyisim alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
