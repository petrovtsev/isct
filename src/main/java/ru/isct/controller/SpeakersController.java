package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import ru.isct.data.Speaker;
import ru.isct.model.SpeakersModel;
import ru.isct.scope.ScopeName;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by ppetrovt on 13.01.2018.
 */
@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
@Getter
@Setter
public class SpeakersController extends AbstarctController {

    private Speaker speaker = new Speaker();

    private List<Speaker> speakers;

    @Autowired
    private SpeakersModel speakersModel;

    @PostConstruct
    public void init() {
        speakers = speakersModel.getAll();
        speaker = new Speaker();
    }

    public void addSpeaker() {
        try {
            speakersModel.save(speaker);
            init();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }


    public void onRowEdit(RowEditEvent event) {
        try {
            Speaker speaker = (Speaker) event.getObject();
            speakersModel.save(speaker);
            init();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }

    public void delete(Speaker speaker) {
        try {
            speakersModel.delete(speaker);
            init();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }

}
