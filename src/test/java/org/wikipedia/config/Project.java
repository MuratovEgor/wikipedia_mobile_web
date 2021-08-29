package org.wikipedia.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static BrowserStackConfig browserStackConfig =
            ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static AppiumConfig appiumConfig =
            ConfigFactory.create(AppiumConfig.class, System.getProperties());

    public static SelenoidConfig selenoidConfig =
            ConfigFactory.create(SelenoidConfig.class, System.getProperties());

}
