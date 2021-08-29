package org.wikipedia.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/appium.properties"
})

public interface AppiumConfig extends Config {

    @Key("platform.name")
    String getPlatformName();

    @Key("device")
    String getDevice();

    @Key("platform.version")
    String getPlatformVersion();

    @Key("platform.locale")
    String getPlatformLocale();

    @Key("platform.language")
    String getPlatformLanguage();

    @Key("app.package")
    String getAppPackage();

    @Key("app.activity")
    String getAppActivity();

    @Key("app.url")
    String getAppUrl();

    @Key("hub.url")
    String getHubUrl();
}