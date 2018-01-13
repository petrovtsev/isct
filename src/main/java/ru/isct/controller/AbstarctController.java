package ru.isct.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by ppetrovt on 13.01.2018.
 */
public abstract class AbstarctController {

    public void message(String message) {
        message("Info", message);
    }


    public void message(String title, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(title, message));
    }
}
