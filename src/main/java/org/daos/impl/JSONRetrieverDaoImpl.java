package org.daos.impl;

import com.google.gson.Gson;
import org.daos.JSONRetrieverDao;

public class JSONRetrieverDaoImpl implements JSONRetrieverDao {

    @Override
    public Object getLegalGeneric(String legalType, String campaign, Class<?> clazz) {
        System.out.println("Searching for legalType: " + legalType + " with campaign: " + campaign);
        return new Gson().fromJson("{\"legal\": \"Ipsolorum  + ${param1} +  bla bla  + ${param2} + , y va a terminar con  + ${param3} + .\", \"param1\":\"p1\", \"param2\":\"p2\", \"param3\":\"p3\"}",
                clazz);
    }
}
