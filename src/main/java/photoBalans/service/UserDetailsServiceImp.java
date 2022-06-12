package photoBalans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photoBalans.dao.UserDao;
import photoBalans.models.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private BeeService beeService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.authorities("USER");
            String res = initializationRes(user.getRes());
            BeeService.setRes(res);
            System.out.println(BeeService.getRes());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private String initializationRes(String res) {
        switch (res) {
            case "VRES": return "v";
            case "ZRES": return "z";
            case "SRES": return "s";
            case "URES": return "u";
            default: return null;
        }
    }
}
