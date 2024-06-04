package com.banco.bci.evaluationjava.dao;

import com.banco.bci.evaluationjava.models.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<Users, Long> {

    Users findUsersByEmail(String email);

}
