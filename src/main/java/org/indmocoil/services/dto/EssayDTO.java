package org.indmocoil.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EssayDTO {
    private String essayId;
    private String heading;
    private String essaytext;
    private String headLine;
    private Date inputdtm;
    private String status;
    private String subheading;
}
