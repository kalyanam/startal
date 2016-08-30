package com.startal.handler;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.json.JsonObject;

/**
 * Created by mkalyan on 8/29/16.
 */
public class CreateNewProfileTest {
    public void start() {
        Vertx vertx = Vertx.vertx();
        HttpClientOptions httpClientOptions = new HttpClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(5000);

        HttpClient httpClient = vertx.createHttpClient(httpClientOptions);
        JsonObject profile = makeProfile("Kalyan M", "kalyananm@gmail.com", "1234567890", "New York, NY", "Any",
                "Best Role Ever", "Mid level", "BS", "Yes", "Yes", "Startup", "Passive", "Startup Again", "Yes",
                "1st Sept 2016", "I am ready! Am I?", "This is going to be a decent profile that you will like. Some random text. Some random text. Some random text" +
                        "Some random text. Some random text. Some random text. Some random text. Some random text. Some random text. Some random text. Some random text. Some random text");

        System.out.println("Sending out the profile: \n"+profile.encodePrettily());

/*        HttpClientRequest request = httpClient.post("/profile", handler -> {
            System.out.println("Response status is: "+handler.statusCode());
            handler.bodyHandler(buffer -> {
                System.out.println("Response body is: "+buffer.toString());
            });
        });
        request.putHeader("content-type", "application/json");
        request.putHeader("content-length", profile.encode().length()+"");
        request.write(profile.encode());
        System.out.println("Sending the request....");
        request.end();*/
    }

    private JsonObject makeProfile(String fullName, String email, String contactNumber, String location, String interestedArea,
                                   String topPreferredRole, String experienceType, String educationType, String willingToRelocate,
                                   String sponsorshipRequired, String preferredCompanySize, String activePassive, String preferredEmpType,
                                   String okForVetting, String dateForVetting, String subject, String message) {
        JsonObject profile = new JsonObject();
        profile.put("fullName", fullName);
        profile.put("email", email);
        profile.put("contactNumber", contactNumber);
        profile.put("location", location);
        profile.put("interestedArea", interestedArea);
        profile.put("topPreferredRole", topPreferredRole);
        profile.put("experienceType", experienceType);
        profile.put("educationType", educationType);
        profile.put("willingToRelocate", willingToRelocate);
        profile.put("sponsorshipRequired", sponsorshipRequired);
        profile.put("preferredCompanySize", preferredCompanySize);
        profile.put("activePassive", activePassive);
        profile.put("preferredEmpType", preferredEmpType);
        profile.put("okForVetting", okForVetting);
        profile.put("dateForVetting", dateForVetting);
        profile.put("subject", subject);
        profile.put("message", message);

        return profile;
    }

    public static void main(String[] args) {
        new CreateNewProfileTest().start();
    }
}
