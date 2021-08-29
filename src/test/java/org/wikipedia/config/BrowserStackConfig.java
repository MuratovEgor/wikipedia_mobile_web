package org.wikipedia.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface BrowserStackConfig extends Config {

    @Key("user")
    String getBrowserStackUser();

    @Key("key")
    String getBrowserStackKey();

    @Key("api.url")
    String getBrowserStackApiUrl();

    @Key("url")
    String getBrowserStackUrl();

    @Key("device")
    String getBrowserDevice();

    @Key("platform.version")
    String getBrowserPlatformVersion();

    @Key("app")
    String getBrowserStackApp();

    @Key("project")
    String getBrowserStackProject();

    @Key("build")
    String getBrowserStackBuild();

    @Key("name")
    String getBrowserStackName();

    @Key("app.url")
    String getAppUrl();
}