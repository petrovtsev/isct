package ru.isct.service;

import ru.isct.data.Guest;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ppetrovt on 12.01.2018.
 */
public interface GuestService extends CrudRepository<Guest, Long> {

}
