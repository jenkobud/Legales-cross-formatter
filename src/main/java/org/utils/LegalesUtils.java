package org.utils;

import org.daos.impl.JSONRetrieverDaoImpl;
import org.models.LegalJsonDto;

import java.util.Arrays;
import java.util.Map;

public class LegalesUtils {
    private static final String EMPTY = "";
    private static final JSONRetrieverDaoImpl jsonRetrieverDao = new JSONRetrieverDaoImpl();
    public static String createLegalGeneric(String legalType, String campaign) {
        System.out.println("createLegalGenerico con legalType: " + legalType + " y campaign: " + campaign);
        LegalJsonDto legalObj = (LegalJsonDto) jsonRetrieverDao.getLegalGeneric(legalType, campaign, LegalJsonDto.class);
        return replaceParams(legalObj.getLegal(), legalObj.getSeparator(), legalObj.getAtributesAsMap());
    }

    private static String replaceParams(String legal, String separator, Map attributes) {
        String[] parts = legal.split(separator);
        for(int i=0; i < parts.length; i++) {
            if(!parts[i].startsWith("${") || !parts[i].endsWith("}")) continue;
            try {
                System.out.println("Part: " + parts[i]);
                String attribute = parts[i].replace("${", EMPTY).replace("}", EMPTY);
                System.out.println("Setting attribute: " + attribute);
                parts[i] = (String) attributes.get(attribute);
            } catch (Exception e) {
                System.out.println("An error happened while replacing the value: " + e.getMessage());
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(parts).forEach(sb::append);
        return sb.toString();
    }
    private LegalesUtils() { }
}
