package ru.isct.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by ppetrovt on 13.01.2018.
 */
public abstract class AbstarctController {

    void message(String message) {
        message("Info", message);
    }


    void message(String title, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }

    void errorMessage(String message) {
        errorMessage("Error", message);

    }

    void errorMessage(String title, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }
}
