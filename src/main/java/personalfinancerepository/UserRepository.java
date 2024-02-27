package personalfinancerepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personalfinance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
