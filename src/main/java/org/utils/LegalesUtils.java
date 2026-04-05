package org.utils;

import org.daos.impl.JSONRetrieverDaoImpl;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LegalesUtils {

    private static final Logger LOGGER = Logger.getLogger(LegalesUtils.class.getName());

    private static final String EMPTY = "";
    private static final String DEFAULT_SEPARATOR = " \\+ ";

    private static final String LEGAL = "legal";
    private static final String SEPARATOR = "separator";
    private static final JSONRetrieverDaoImpl jsonRetrieverDao = new JSONRetrieverDaoImpl();

    private LegalesUtils() { }

    public static String createLegalGeneric(String legalType, String campaign) {
        LOGGER.log(Level.INFO, () -> "createLegalGenerico con legalType: " + legalType + " y campaign: " + campaign);
        Map<String, String> legalMap = jsonRetrieverDao.getLegalGeneric(legalType, campaign);
        String separator = legalMap.get(SEPARATOR) != null ? legalMap.get(SEPARATOR) : DEFAULT_SEPARATOR;
        return replaceParams(legalMap.get(LEGAL), separator, legalMap);
    }

    private static String replaceParams(String legal, String separator, Map<String, String> attributes) {
        String[] parts = legal.split(separator);
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].startsWith("${") || !parts[i].endsWith("}")) continue;

            LOGGER.log(Level.INFO, "Part: {0}", parts[i]);
            String attribute = parts[i].replace("${", EMPTY).replace("}", EMPTY);
            LOGGER.log(Level.INFO, () -> "Setting attribute: " + attribute);
            parts[i] = attributes.get(attribute);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(parts).forEach(sb::append);
        return sb.toString();
    }
}
