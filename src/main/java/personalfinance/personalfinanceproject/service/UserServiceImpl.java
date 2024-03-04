package personalfinance.personalfinanceproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personalfinance.personalfinanceproject.model.User;
import personalfinance.personalfinanceproject.exception.UserNotFoundException;
import personalfinance.personalfinanceproject.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
@Autowired 
   UserRepository userRepository;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public User getUserProfile(Long userId) {
		if (userRepository.findById(userId).isEmpty()) {
			 throw new UserNotFoundException("Requested User does not exist");
		}
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
	}

	@Override
	public User updateUser(User user) {
		if(getUser(user.getUserId()) == null) {
			throw new UserNotFoundException("Requested User does not exist to Update");
		}
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String Password) {
		if (userRepository.findbyEmailAndPassword(email,Password) == null) {
			throw new UserNotFoundException("Invalid UserName or Password");
		}
		return userRepository.findbyEmailAndPassword(email, Password);
	}
	@Override
	public User getUser(Long userId) {
		if (userRepository.findById(userId).isEmpty()) {
			throw new UserNotFoundException("Requested User does not exist");

		}
		return userRepository.findById(userId).get();

	}
	@Override
	public User updateUserProfile(Long userId, User updateUser) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
