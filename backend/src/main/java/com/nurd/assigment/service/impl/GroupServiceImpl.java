package com.nurd.assigment.service.impl;

import com.nurd.assigment.model.Group;
import com.nurd.assigment.model.User;
import com.nurd.assigment.service.api.GroupServiceApi;
import com.nurd.assigment.service.api.UserServiceApi;
import com.nurd.assigment.service.repository.GroupServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("groupService")
public class GroupServiceImpl implements GroupServiceApi {

    @Autowired
    GroupServiceRepo groupServiceRepo;

    @Autowired
    UserServiceApi userService;
    @Override
    public boolean save(Group group) {
        group.setCreator(userService.getLoginUser());
        Group g = groupServiceRepo.save(group);
        return g.getId() != 0 ? true : false;
    }

    @Override
    public List<Group> getGroups() {
        return groupServiceRepo.getUsersGroup(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
