package org.wikipedia.config;
import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/host.properties"
})
public interface HostConfig extends Config {
    @Key("driver")
    String getDriver();
}
