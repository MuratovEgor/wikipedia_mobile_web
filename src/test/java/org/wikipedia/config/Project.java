package org.wikipedia.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static BrowserStackConfig browserStackConfig =
            ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

}