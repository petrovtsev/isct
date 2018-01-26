package ru.isct.model;

import ru.isct.data.CommitteeMember;
import ru.isct.service.CommitteeMemberService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by ppetrovt on 19.01.2018.
 */
@Service
public class CommitteeMemberModel {

    @Autowired
    private CommitteeMemberService committeeMemberService;

    public List<CommitteeMember> getAll() {
        List<CommitteeMember> committeeMembers = new ArrayList<>();
        committeeMemberService.findAll().forEach(committeeMembers::add);
        return committeeMembers;
    }

    public void save(CommitteeMember committeeMember) throws Exception {
        committeeMemberService.save(committeeMember);
    }

    public void delete(CommitteeMember committeeMember) throws Exception {
        committeeMemberService.delete(committeeMember);
    }

    public CommitteeMember get(Integer id) throws Exception {
        return committeeMemberService.findOne(id);
    }
}
