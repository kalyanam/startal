package com.startal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by mkalyan on 8/29/16.
 */
public class ProfileDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProfileDAO.class);
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_NEW = "INSERT INTO PROFILES (FULL_NAME, EMAIL, CONTACT_NUMBER, LOCATION, INTERESTED_AREA," +
            "TOP_PREFERRED_ROLE, EXPERIENCE_TYPE, EDUCATION_TYPE, WILLING_TO_RELOCATE, SPONSORSHIP_REQUIRED, PREFERRED_COMPANY_SIZE," +
            "ACTIVE_PASSIVE, PREFERRED_EMPLOYMENT_TYPE, OK_FOR_VETTING, DATE_FOR_VETTING, SUBJECT, MESSAGE, JOINED_DATE) VALUES " +
            "('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', now() )";

    private static final String SELECT_ALL = "SELECT * FROM PROFILES";

    public ProfileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createNewProfile(String fullName, String email, String contactNumber, String location, String interestedArea,
                                 String topPreferredRole, String experienceType, String educationType, String willingToRelocate,
                                 String sponsorshipRequired, String preferredCompanySize, String activePassive, String preferredEmpType,
                                 String okForVetting, String dateForVetting, String subject, String message) {
        String sql = String.format(INSERT_NEW, fullName, email, contactNumber, location, interestedArea, topPreferredRole,
                experienceType, educationType, willingToRelocate, sponsorshipRequired, preferredCompanySize, activePassive, preferredEmpType,
                okForVetting, dateForVetting, subject, message);
        logger.info("Executing sql: {}", sql);

        jdbcTemplate.execute(sql);
    }

    public List<Map<String, Object>> getAllProfiles() {
        return jdbcTemplate.queryForList(SELECT_ALL);
    }
}
