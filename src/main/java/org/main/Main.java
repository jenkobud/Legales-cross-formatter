package org.main;

import org.utils.LegalesUtils;

public class Main {
    public static void main(String[] args) {
        String legal = LegalesUtils.createLegalGeneric("tipo1", "principal");
        System.out.println(legal);

    }
}