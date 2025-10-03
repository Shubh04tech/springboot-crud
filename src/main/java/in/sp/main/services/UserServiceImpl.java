package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		
		return userrepository.findAll();
	}

	@Override
	public Optional<User> getUserDetails(int id) {
		
		return userrepository.findById(id);
	}

	@Override
	public User updateUserDetails(int id, User newuser) {
		User userdata=userrepository.findById(id).orElse(null);
		if(userdata!=null) {
			return userrepository.save(newuser);
		}
		else {
			
			 throw new RuntimeException("User not found with id"+id);
		}
		
	}

	@Override
	public void deleteUser(int id) {
		userrepository.deleteById(id);
	}

	@Override
	public User findByEmail(String email) {
		return userrepository.findByEmail(email);
	}

}
