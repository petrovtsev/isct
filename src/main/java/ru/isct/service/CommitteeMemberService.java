package ru.isct.service;


import ru.isct.data.CommitteeMember;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ppetrovt on 12.01.2018.
 */
public interface CommitteeMemberService extends CrudRepository<CommitteeMember, Integer> {

}
