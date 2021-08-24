package org.wikipedia.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface MobileConfig extends Config {

    @Key("user")
    String getBrowserStackUser();

    @Key("key")
    String getBrowserStackKey();
}