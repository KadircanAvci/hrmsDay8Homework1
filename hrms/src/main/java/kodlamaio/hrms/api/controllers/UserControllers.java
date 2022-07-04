package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entites.concretes.User;

@RestController
@RequestMapping ("/api/users")
public class UserControllers {

	private UserService userService;
	
	
	@Autowired
	public UserControllers (UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@GetMapping ("getAll")
		public DataResult<List<User>> getAll(){
		
			return this.userService.getAll();
	}
	
		
	
	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
}
