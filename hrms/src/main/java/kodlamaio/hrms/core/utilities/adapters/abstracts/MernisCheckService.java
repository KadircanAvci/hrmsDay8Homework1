package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.JobSeekers;

public interface MernisCheckService {
	Result checkIfRealPerson(JobSeekers jobSeekers) throws Exception;
}
