package org.wikipedia.helpers;

import org.aeonbits.owner.ConfigFactory;
import org.wikipedia.config.BrowserStackConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {

    static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(config.getBrowserStackUser(), config.getBrowserStackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}