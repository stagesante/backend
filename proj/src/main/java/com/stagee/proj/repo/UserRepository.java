package com.stagee.proj.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stagee.proj.model.User;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
	User findByPseudo(String pseudo);

}
