package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.CompanyNameValidator;
import kodlamaio.hrms.core.utilities.validations.EmailValidator;
import kodlamaio.hrms.core.utilities.validations.EmailWebsSiteDomainValidator;
import kodlamaio.hrms.core.utilities.validations.PasswordValidator;
import kodlamaio.hrms.core.utilities.validations.PhoneNumberValidator;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entites.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private HrmsApproveService hrmsApproveService;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public EmployerManager (EmployerDao employerDao, HrmsApproveService hrmsApproveService, EmailVerificationService emailVerificationService) {
		this.employerDao = employerDao;
		this.hrmsApproveService = hrmsApproveService;
		this.emailVerificationService = emailVerificationService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
	}
	public Result isEmailExist(String email) {
		if((this.employerDao.findByEmail(email) == null)) {
			return new SuccessResult();
		}
		return new ErrorResult();
		
	}
	
	
	
	
	@Override
	public Result add(Employer employer) {
		
		Result companyNameValid = CompanyNameValidator.valid(employer.getCompanyName());
		Result emailValid = EmailValidator.valid(employer.getEmail());
		Result emailWebSitesDomainValid = EmailWebsSiteDomainValidator.valid(employer.getWebSites(),employer.getEmail());
		Result passwordValid = PasswordValidator.valid(employer.getPassword(), employer.getRepassword());
		Result phoneNumberValid= PhoneNumberValidator.valid(employer.getPhoneNumber());
		
		if(!companyNameValid.isSuccess()) {
			return new ErrorResult(companyNameValid.getMessage());
		}
		else if(!emailValid.isSuccess()) {
			return new ErrorResult(emailValid.getMessage());
		}
		else if(!emailWebSitesDomainValid.isSuccess()) {
			return new ErrorResult(emailWebSitesDomainValid.getMessage());
		}
		else if(!passwordValid.isSuccess()) {
			return new ErrorResult(passwordValid.getMessage());
		}
		else if(!phoneNumberValid.isSuccess()) {
			return new ErrorResult(phoneNumberValid.getMessage());
		}
		else if(!this.hrmsApproveService.isApproved(employer).isSuccess()) {
			return new ErrorResult("Üyelik sistem personeli tarafından onaylanmamıştır.");
		}
		else if(!this.emailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email doğrulaması yapılmadı");
		}
		else if(!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Mail adresi daha önce kullanılmıştır");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kullanıcı kaydedildi.");
		
		
	}
			

	}


