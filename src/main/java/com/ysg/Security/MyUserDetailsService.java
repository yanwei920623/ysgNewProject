package com.ysg.Security;

import com.ysg.entity.TbUser;
import com.ysg.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TbUser tbUser = tbUserService.findUserByName(username);
        if(tbUser!=null){
//            System.out.println("查找用户：" + username+"密码："+tbUser);
            User user = new User(tbUser.getUsername(),new BCryptPasswordEncoder().encode(tbUser.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
            return user;
        }
        return null;
    }

}
