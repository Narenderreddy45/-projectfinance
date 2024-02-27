package personalfinanceservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personalfinance.model.User;
import personalfinancerepository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;



// @Autowired
//  public UserService(UserRepository userRepository){
//	  this.userRepository =userRepository;
//	  }
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserProfile(Long userId) {
		User user = userRepository.findById(userId).get();
		return user;

	}

	public User updateUserProfile(Long userId, User upadatedUser) {
		User existingUser = userRepository.findById(userId).orElse(null);
		if (existingUser != null) {
			existingUser.setEmail(upadatedUser.getEmail());
			existingUser.setFirstName(upadatedUser.getFirstName());
			
			return userRepository.save(existingUser);
		}
		return null;
	}
}
