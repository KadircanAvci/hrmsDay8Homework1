package kodlamaio.hrms.core.utilities.adapters.concretes;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entites.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public Result checkIfRealPerson(JobSeekers jobSeekers) throws Exception {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentificationNumber()), jobSeekers.getName(), jobSeekers.getLastName(), Integer.parseInt(jobSeekers.getDateOfBirth()));
		
		if(result == false) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}

}
