package com.startal.handler;

import com.startal.dao.ProfileDAO;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
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

    }
}
