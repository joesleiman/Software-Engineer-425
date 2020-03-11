package edu.miu.carRental.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.miu.carRental.config.UserPrincipal;
import edu.miu.carRental.domain.User;
import edu.miu.carRental.repository.UserRepository;

@Service
public class CarRentalUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username+" is not found");
		}
		return new UserPrincipal(user);
	}

}
