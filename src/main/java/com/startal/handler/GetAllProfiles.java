package com.startal.handler;

import com.startal.dao.ProfileDAO;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by mkalyan on 8/29/16.
 */
public class GetAllProfiles {
    private static final Logger logger = LoggerFactory.getLogger(GetAllProfiles.class);
    private ProfileDAO profileDAO;

    public GetAllProfiles(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public void handle(RoutingContext routingContext) {
        List<Map<String, Object>> profiles = profileDAO.getAllProfiles();
        routingContext.response().setStatusCode(HttpStatus.OK_200).end(new JsonArray(profiles).encode());
    }
}
