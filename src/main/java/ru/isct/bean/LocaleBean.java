package ru.isct.bean;

import lombok.Getter;
import ru.isct.scope.ScopeName;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by ppetrovt on 24.01.2018.
 */
@Controller
@Scope(ScopeName.SESSION)
@ManagedBean
public class LocaleBean implements Serializable {

    @Getter
    private Locale currentLocale;

    @PostConstruct
    public void init() {
        currentLocale = Locale.ENGLISH;
    }

    public void changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
        RequestContext.getCurrentInstance().execute("location.reload();");
    }

    public boolean isLocalEng(){
        return currentLocale.equals(Locale.ENGLISH);
    }

}
