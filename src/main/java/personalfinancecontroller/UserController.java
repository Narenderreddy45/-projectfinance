package personalfinancecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personalfinance.model.User;
import personalfinanceservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userSerice;

	@Autowired
	public UserController(UserService userService) {
		this.userSerice = userService;
	}

	@PostMapping("/Create")
	public User createuser(@RequestBody User user) {
		return userSerice.createUser(user);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
		@SuppressWarnings("unchecked")
		User userProfile = (User) userSerice.getUserProfile(userId);
		if (userProfile != null) {
			return new ResponseEntity<>(userProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userProfile, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserProfile(@PathVariable Long userId, @RequestBody User updateUser) {
		@SuppressWarnings("unchecked")
		User updateUserProfile = (User) userSerice.updateUserProfile(userId, updateUser);
		if (updateUserProfile != null) {
			return new ResponseEntity<>(updateUserProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}