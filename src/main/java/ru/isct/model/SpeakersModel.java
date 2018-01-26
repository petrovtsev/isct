package ru.isct.model;


import ru.isct.data.Speaker;
import ru.isct.service.SpeakerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppetrovt on 18.01.2018.
 */
@Service
public class SpeakersModel {

    @Autowired
    private SpeakerService speakerService;

    public List<Speaker> getAll() {
        List<Speaker> speakers = new ArrayList<>();
        speakerService.findAll().forEach(speakers::add);
        return speakers;
    }

    public void save(Speaker speaker) throws Exception {
        speakerService.save(speaker);
    }

    public void delete(Speaker speaker) throws Exception {
        speakerService.delete(speaker);
    }
}
