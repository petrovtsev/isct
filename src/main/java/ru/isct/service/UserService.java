package ru.isct.service;


import ru.isct.data.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ppetrovt on 12.01.2018.
 */
public interface UserService extends CrudRepository<User, String> {

}
