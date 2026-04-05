package org.models;

import lombok.Getter;
import lombok.Setter;

/**
 * LegalJsonDto
 *  Other way to represent the JSON object, for the moment this impl will be Deprecated. JEB
 */

@Deprecated
@Getter
@Setter
public class LegalJsonDto extends ObjectWDynamicFields {
    private String legal;
    private String separator = " \\+ ";
    private String param1;
    private String param2;
    private String param3;
}
