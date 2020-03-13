package edu.miu.carRental.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import edu.miu.carRental.domain.User;
import edu.miu.carRental.domain.UserPrincipal;
import edu.miu.carRental.repository.UserRepository;

@Service
public class CarRentalUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + " is not found"));
		return user.map(UserPrincipal::new).get();
	}
	
	


}
