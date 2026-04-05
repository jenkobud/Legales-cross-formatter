package org.daos.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.daos.JSONRetrieverDao;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONRetrieverDaoImpl implements JSONRetrieverDao {

    private static final Logger LOGGER = Logger.getLogger(JSONRetrieverDaoImpl.class.getName());
    @Override
    public Map<String, String> getLegalGeneric(String legalType, String campaign) {
        LOGGER.log(Level.INFO, () -> "Searching for legalType: " + legalType + " with campaign: " + campaign);

        Type type = new TypeToken<Map<String, String>>(){}.getType();

        return new Gson().fromJson(
                "{\"legal\": \"Ipsolorum  + ${param1} +  bla bla  + ${param2} + , y va a terminar con  + ${param3} + .\", \"param1\":\"p1\", \"param2\":\"p2\", \"param3\":\"p3\"}",
                type);
    }
}
