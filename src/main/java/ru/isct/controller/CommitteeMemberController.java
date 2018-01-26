package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import ru.isct.data.CommitteeMember;
import ru.isct.model.CommitteeMemberModel;
import ru.isct.scope.ScopeName;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by ppetrovt on 19.01.2018.
 */
@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
@Getter
@Setter
public class CommitteeMemberController extends AbstarctController {

    @Autowired
    private CommitteeMemberModel committeeMemberModel;

    private List<CommitteeMember> committeeMemberList;

    private CommitteeMember committeeMember;

    @PostConstruct
    public void init() {
        committeeMember = new CommitteeMember();
        committeeMemberList = committeeMemberModel.getAll();
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            CommitteeMember committeeMember = (CommitteeMember) event.getObject();
            committeeMemberModel.save(committeeMember);
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }

    public void add() {
        try {
            committeeMemberModel.save(committeeMember);
            init();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }

    public void delete(CommitteeMember committeeMember) {
        try {
            committeeMemberModel.delete(committeeMember);
            init();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }

    public List<CommitteeMember> getOrgCommitteeMembers() {
        return committeeMemberList.stream().filter(CommitteeMember::isOrganizingMember).collect(Collectors.toList());
    }

    public List<CommitteeMember> getProgramCommitteeMembers() {
        return committeeMemberList.stream().filter(CommitteeMember::isProgramMember).collect(Collectors.toList());
    }
}
