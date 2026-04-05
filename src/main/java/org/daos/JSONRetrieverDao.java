package org.daos;

import java.util.Map;

public interface JSONRetrieverDao {

    /**
     * Get legal generic
     * @param legalType
     * @param campaign
     * @param clazz
     * @return
     */
    Map<String, String> getLegalGeneric(String legalType, String campaign);
}
