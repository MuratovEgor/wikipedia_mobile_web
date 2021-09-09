package org.wikipedia.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static BrowserStackConfig browserStackConfig =
            ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static AppiumConfig appiumConfig =
            ConfigFactory.create(AppiumConfig.class, System.getProperties());

    public static WebConfig webConfig =
            ConfigFactory.create(WebConfig.class, System.getProperties());

    public static HostConfig hostConfig =
            ConfigFactory.create(HostConfig.class, System.getProperties());
}
