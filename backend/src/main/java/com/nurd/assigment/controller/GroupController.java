package com.nurd.assigment.controller;

import com.nurd.assigment.model.Group;
import com.nurd.assigment.model.User;
import com.nurd.assigment.service.api.GroupServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@EnableWebSecurity
@CrossOrigin(origins = "*")
@RequestMapping("api/secured/")
public class GroupController {

    @Autowired
    GroupServiceApi groupService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    boolean  save(@RequestBody Group group) throws Exception {
        User creator = new User();
        creator.setEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        group.setCreator(creator);
        return groupService.save(group);
    }

    @PostMapping(value = "getGroups")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Group> getGroups() throws Exception {
        return groupService.getGroups();
    }
}
