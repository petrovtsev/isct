package ru.isct.service;

import ru.isct.data.Speaker;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ppetrovt on 12.01.2018.
 */
public interface SpeakerService extends CrudRepository<Speaker, Long> {

}
