package swd20.IDDB.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import swd20.IDDB.domain.User;
import swd20.IDDB.domain.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User curruser = userRepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
				curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}