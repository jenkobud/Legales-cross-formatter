package org.daos;

public interface JSONRetrieverDao {

    Object getLegalGeneric(String legalType, String campaign, Class<?> clazz);
}
