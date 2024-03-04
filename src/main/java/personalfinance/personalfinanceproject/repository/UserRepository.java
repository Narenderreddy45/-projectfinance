package personalfinance.personalfinanceproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personalfinance.personalfinanceproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findbyEmailAndPassword(String email, String password);
	
}
