package com.nurd.assigment.service.impl;

import com.nurd.assigment.model.User;
import com.nurd.assigment.service.api.UserServiceApi;
import com.nurd.assigment.service.repository.UserServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component("userService")
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    UserServiceRepo userServiceRepo;

    @Override
    public User getUser(User user) {
        return userServiceRepo.getUserByEmail(user.getEmail());
    }

    @Override
    public boolean save(User user) {
       return userServiceRepo.save(user) != null ? true : false;
    }

    @Override
    public User getLoginUser() {
        return userServiceRepo.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }


}
