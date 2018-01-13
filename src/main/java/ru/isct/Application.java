package ru.isct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ru.isct.scope.SessionReplicationAwareScopeMetadataResolver;

/**
 * Call http://localhost:8080/index.xhtml after starting the application.
 * 
 * @author MIS
 *
 */
@SpringBootApplication
@ComponentScan(scopeResolver = SessionReplicationAwareScopeMetadataResolver.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
