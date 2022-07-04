package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.DateOfBirthValidator;
import kodlamaio.hrms.core.utilities.validations.EmailValidator;
import kodlamaio.hrms.core.utilities.validations.FirstNameValidator;
import kodlamaio.hrms.core.utilities.validations.IdentificationNumberValidator;
import kodlamaio.hrms.core.utilities.validations.LastNameValidator;
import kodlamaio.hrms.core.utilities.validations.PasswordValidator;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entites.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private EmailVerificationService emailVerificationService;
	private MernisCheckService mernisCheckService;
	
	
	@Autowired
	public JobSeekersManager (JobSeekersDao jobSeekersDao, EmailVerificationService emailVerificationService, MernisCheckService mernisCheckService) {
		this.jobSeekersDao = jobSeekersDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisCheckService = mernisCheckService;
		
	}
	
	@Override
	public DataResult<List<JobSeekers>> getAll() {
		
		return new SuccessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(), "İş arayanlar listelendi");
	}
	
	
	public Result isEmailExist(String email) {
		if(this.jobSeekersDao.findByEmail(email) == null) {
			return new SuccessResult();
					}
		return new ErrorResult();
	}
	public Result isIdentificationNumberExist(String identificationNumber) {
		 if(this.jobSeekersDao.findByIdentificationNumber(identificationNumber) == null) {
			 return new SuccessResult();
		 }
		 return new ErrorResult();
	 }
	
		
	

	@Override
	public Result add(JobSeekers jobSeekers) throws Exception {
		
		Result firstNameValid = FirstNameValidator.valid(jobSeekers.getName());
		Result lastNameValid = LastNameValidator.valid(jobSeekers.getLastName());
		Result emailValid = EmailValidator.valid(jobSeekers.getEmail());
		Result passwordValid = PasswordValidator.valid(jobSeekers.getPassword(), jobSeekers.getRepassword());
		Result identificationNumberValid = IdentificationNumberValidator.valid(jobSeekers.getIdentificationNumber());
		Result dateOfBirthValid = DateOfBirthValidator.valid(jobSeekers.getDateOfBirth());
		
		
		if(!firstNameValid.isSuccess()) {
			return new ErrorResult(firstNameValid.getMessage());
		}
		else if(!lastNameValid.isSuccess()) {
			return new ErrorResult(lastNameValid.getMessage());
		}
		else if(!emailValid.isSuccess()) {
			return new ErrorResult(emailValid.getMessage());
		}
		else if(!passwordValid.isSuccess()) {
			return new ErrorResult(passwordValid.getMessage());
		}
		else if(!identificationNumberValid.isSuccess()) {
			return new ErrorResult(identificationNumberValid.getMessage());
		}
		else if(!dateOfBirthValid.isSuccess()) {
			return new ErrorResult(dateOfBirthValid.getMessage());
		}
		else if(!this.emailVerificationService.verifyEmail(jobSeekers.getEmail()).isSuccess()){
			return new ErrorResult("Email doğrulaması başarısız");
		}
		
		else if(!this.isEmailExist(jobSeekers.getEmail()).isSuccess()) {
			return new ErrorResult("Mail adresi daha önce kullanılmıştır");
		}
		else if(!this.isIdentificationNumberExist(jobSeekers.getIdentificationNumber()).isSuccess()) {
			return new ErrorResult("T.C. Kimlik numarası daha önce kullanılmıştır.");
		}
		//else if(!this.mernisCheckService.checkIfRealPerson(jobSeekers).isSuccess()) {
			//return new ErrorResult("Kullanıcı bulunamadı");
		//}
		
		
		this.jobSeekersDao.save(jobSeekers);
		return new SuccessResult("İş arayan sisteme eklendi.");
		
		
	}

	
	
	

}
