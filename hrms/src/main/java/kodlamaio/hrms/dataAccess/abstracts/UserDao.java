package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entites.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	List<User> getByEmailContains(String email);
}
