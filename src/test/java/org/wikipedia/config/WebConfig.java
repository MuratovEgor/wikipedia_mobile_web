package org.wikipedia.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web.properties"
})

public interface WebConfig extends Config {
    @Key("url")
    String getSelenoidUrl();

    @Key("selenoid.video.storage")
    String getSelenoidVideoStorage();

    @Key("browser")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("browser.size")
    String getBrowserSize();

}