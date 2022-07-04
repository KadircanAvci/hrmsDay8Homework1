package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class CompanyNameValidator {
	public static Result valid (String companyName) {
		
		if(companyName.isEmpty()) {
			return new ErrorResult("Şirket ismi alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
