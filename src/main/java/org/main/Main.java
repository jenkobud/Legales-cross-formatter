package org.main;

import org.utils.LegalesUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String legal = LegalesUtils.createLegalGeneric("tipo1", "principal");
        LOGGER.log(Level.INFO, () -> legal);

    }
}
