package com.frameworks.helpers;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frameworks.constants.FrameworkConstants;

public class JsonHelper {

    public static void writeUsertoFile(pojoForSignupdata user) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(FrameworkConstants.JSON_LOCATION), user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static JsonNode readUserFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(new File(FrameworkConstants.JSON_LOCATION));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
