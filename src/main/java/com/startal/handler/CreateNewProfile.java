package com.startal.handler;

import com.startal.dao.ProfileDAO;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mkalyan on 8/29/16.
 */
public class CreateNewProfile {
    private static final Logger logger = LoggerFactory.getLogger(CreateNewProfile.class);
    private ProfileDAO profileDAO;

    public CreateNewProfile(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public void handle(RoutingContext routingContext) {
        String body = routingContext.getBodyAsJson().encodePrettily();
        logger.info("Body is: {}", body);
        JsonObject jsonObject = new JsonObject(body);

        String fullName = jsonObject.getString("fullName");
        String email = jsonObject.getString("email");
        String contactNumber = jsonObject.getString("contactNumber");
        String location = jsonObject.getString("location");
        String interestedArea = jsonObject.getString("interestedArea");
        String topPreferredRole = jsonObject.getString("topPreferredRole");
        String experienceType = jsonObject.getString("experienceType");
        String educationType = jsonObject.getString("educationType");
        String willingToRelocate = jsonObject.getString("willingToRelocate");
        String sponsorshipRequired = jsonObject.getString("sponsorshipRequired");
        String preferredCompanySize = jsonObject.getString("preferredCompanySize");
        String activePassive =jsonObject.getString("activePassive");
        String preferredEmpType = jsonObject.getString("preferredEmpType");
        String okForVetting = jsonObject.getString("okForVetting");
        String dateForVetting =jsonObject.getString("dateForVetting");
        String subject = jsonObject.getString("subject");
        String message = jsonObject.getString("message");

        profileDAO.createNewProfile(fullName, email, contactNumber, location, interestedArea, topPreferredRole,
                experienceType, educationType, willingToRelocate, sponsorshipRequired, preferredCompanySize,
                activePassive, preferredEmpType, okForVetting, dateForVetting, subject, message);

        routingContext.response().setStatusCode(HttpStatus.CREATED_201).end(new JsonObject().put("status", "success").encode());
    }
}
