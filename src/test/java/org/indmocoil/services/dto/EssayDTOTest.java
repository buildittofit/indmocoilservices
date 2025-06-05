package org.indmocoil.services.dto;

import org.indmocoil.services.dto.EssayDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EssayDTOTest {

    @Test
    void testGettersAndSetters() {
        EssayDTO dto = new EssayDTO();
        dto.setEssayId("1");
        dto.setHeading("heading");
        dto.setEssaytext("text");
        dto.setHeadLine("headline");
        dto.setInputdtm(new Date());
        dto.setStatus("status");
        dto.setSubheading("subheading");

        assertEquals("1", dto.getEssayId());
        assertEquals("heading", dto.getHeading());
        assertEquals("text", dto.getEssaytext());
        assertEquals("headline", dto.getHeadLine());
        assertNotNull(dto.getInputdtm());
        assertEquals("status", dto.getStatus());
        assertEquals("subheading", dto.getSubheading());
    }
}