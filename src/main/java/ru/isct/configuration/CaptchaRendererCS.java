package ru.isct.configuration;

import javax.faces.context.FacesContext;

import org.primefaces.component.captcha.Captcha;
import org.primefaces.component.captcha.CaptchaRenderer;

/**
 * Created by ppetrovt on 26.01.2018.
 */
public class CaptchaRendererCS extends CaptchaRenderer {

    @Override
    protected String getPublicKey(FacesContext context, Captcha captcha) {
        return "6Lenr0IUAAAAANhr0UIpQvd-ewhzXMYTOOwml24j";
    }
}
