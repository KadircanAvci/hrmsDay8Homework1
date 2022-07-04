package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class WebSitesValidator{
	public static Result valid (String webSites) {
		
		if(webSites.isEmpty()) {
			return new ErrorResult("Web sitesi alanı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
}
