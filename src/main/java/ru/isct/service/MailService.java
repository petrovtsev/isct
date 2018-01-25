package ru.isct.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ppetrovt on 24.01.2018.
 */
public class MailService {

    private final static String NAME_PROPERTIES = "email.properties";

    private Properties properties;

    public MailService() throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(NAME_PROPERTIES));
    }

    public void send(String recipient, String subject, String body) throws EmailException {
        Email email = new SimpleEmail();
        String username = properties.getProperty("email.username");
        String password = properties.getProperty("email.password");
        email.setSmtpPort(Integer.valueOf(properties.getProperty("email.port")));
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setDebug(Boolean.valueOf(properties.getProperty("email.ssl")));
        email.setHostName(properties.getProperty("email.host"));
        email.getMailSession().getProperties().put("mail.smtps.auth", "true");
        email.getMailSession().getProperties().put("mail.debug", properties.getProperty("email.debug"));
        email.getMailSession().getProperties().put("mail.smtps.port", properties.getProperty("email.port"));
        email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", properties.getProperty("email.port"));
        email.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
        email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
        email.setFrom(properties.getProperty("email.from"), properties.getProperty("email.from.name"));
        email.setSubject(subject);
        email.setMsg(body);
        email.addTo(recipient);
        email.send();
    }

    public static void main(String[] args) {

        try {
            new MailService().send("diro1994@gmail.com", "test", "test");
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
