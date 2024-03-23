package org.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegalJsonDto extends ObjectWDynamicFields {
    private String legal;
    private String separator = " \\+ ";
    private String param1;
    private String param2;
    private String param3;
}
