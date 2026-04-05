package org.daos;

public interface JSONRetrieverDao {

    /**
     * Get the legal object from the JSON file
     * @param legalType
     * @param campaign
     * @param clazz
     * @return
     */
    Object getLegalGeneric(String legalType, String campaign, Class<?> clazz);
}
