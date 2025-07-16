package ru.netology.hw_nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hw_nosql.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
