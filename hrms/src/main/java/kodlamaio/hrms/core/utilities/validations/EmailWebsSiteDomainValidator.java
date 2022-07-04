package kodlamaio.hrms.core.utilities.validations;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class EmailWebsSiteDomainValidator {
	
	public static Result valid(String webSites, String email) {
		
		
		String [] splitWebSites = webSites.split("www.", 2);
		String [] splitEmail = email.split("@", 2);
		
		
		if(!(splitWebSites[1].contains(splitEmail[1]))) {
			return new ErrorResult("Mail adresi ve web sitesi aynı domaine kayıtlı olmalıdır.");
		}
		
		
			return new SuccessResult();
		
		
		
		
	}
}
