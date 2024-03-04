package personalfinance.personalfinanceproject.service;

import personalfinance.personalfinanceproject.model.User;

public interface UserService {
	User createUser(User user);
	User updateUser(User user);
	User loginUser(String email, String Password);
	User getUserProfile(Long userId);
	User getUser(Long userId);
	User updateUserProfile(Long userId, User updateUser);
}
