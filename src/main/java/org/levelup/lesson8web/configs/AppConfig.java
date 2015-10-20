package org.levelup.lesson8web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by proton on 30.06.2015.
 */
@Configuration
@ComponentScan(basePackages = {
        "org.levelup.lesson8web.controllers",
        "org.levelup.lesson8web.services",
        "org.levelup.lesson8web.repositories"
})
@Import({WebMvcConfig.class, PersistenceConfig.class})
public class AppConfig {

}
