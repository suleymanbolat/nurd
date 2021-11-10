package com.nurd.assigment.service.repository;

import com.nurd.assigment.model.Group;
import com.nurd.assigment.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupServiceRepo extends CrudRepository<Group, Long> {

    @Query(value = "select * from groups where creator_email = :email" , nativeQuery = true)
    List<Group> getUsersGroup(@Param("email") String email);

}
