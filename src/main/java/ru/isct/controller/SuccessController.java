package ru.isct.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ru.isct.model.SuccessModel;
import ru.isct.scope.ScopeName;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by ppetrovt on 21.01.2018.
 */
@Controller
@Scope(ScopeName.VIEW)
@ManagedBean
public class SuccessController {

    @Autowired
    SuccessModel successModel;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String key;

    @PostConstruct
    public void proofOfPayment() {
        try {
            System.out.println(id);
            Integer id = Integer.valueOf(this.id);

            //TODO remove
            System.out.println(id);
            successModel.proofOfPayment(id, key);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("https://isct2018.ru/error.xhtml");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
