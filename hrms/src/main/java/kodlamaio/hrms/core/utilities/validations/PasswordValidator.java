package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class PasswordValidator {
	public static Result valid (String password, String repassword) {
		
		if(password.isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz.");
		}
		
		if(repassword.isEmpty()) {
			return new ErrorResult("Şifre tekrarı alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
