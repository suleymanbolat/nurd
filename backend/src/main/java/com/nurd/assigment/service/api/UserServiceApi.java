package com.nurd.assigment.service.api;

import com.nurd.assigment.model.User;

public interface UserServiceApi{

    User getUser(User user);
    boolean save(User user);
    User getLoginUser();
}
