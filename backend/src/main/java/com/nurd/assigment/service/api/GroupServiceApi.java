package com.nurd.assigment.service.api;

import com.nurd.assigment.model.Group;

import java.util.List;

public interface GroupServiceApi {

    boolean save(Group group);

    List<Group> getGroups();
}
