package s2021.bookstoreFinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import s2021.bookstoreFinal.domain.User;
import s2021.bookstoreFinal.domain.UserRepository;


/**
 * This class is used by spring security to authenticate and authorize user
 **/
//@Service
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}


	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	System.out.println("UserDetailServiceImpl: loadUserByUsername " + username);
    	User curruser = repository.findByUsername(username);
    	System.out.println("\"UserDetailServiceImpl: loadUserByUsername current user " + curruser.toString());
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 