package org.indmocoil.services.controllers;
import org.indmocoil.services.controllers.EssayController;
import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.services.EssayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EssayControllerTest {

    @Mock
    private EssayService essayService;

    @InjectMocks
    private EssayController essayController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEssays() {
        when(essayService.getAll()).thenReturn(Collections.emptyList());
        ResponseEntity<?> response = essayController.getAllEssays();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetDistinctHeadings() {
        when(essayService.getDistinctHeadings()).thenReturn(Collections.emptyList());
        ResponseEntity<?> response = essayController.getDistinctHeadings();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetEssayById() {
        when(essayService.getById("1")).thenReturn(new EssayDTO());
        ResponseEntity<?> response = essayController.getEssayById("1");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetEssaysByHeading() {
        when(essayService.getByHeading("heading")).thenReturn(Collections.emptyList());
        ResponseEntity<?> response = essayController.getEssaysByHeading("heading");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testSaveEssay() {
        EssayDTO dto = new EssayDTO();
        when(essayService.save(dto)).thenReturn(dto);
        ResponseEntity<?> response = essayController.saveEssay(dto);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateEssay() {
        EssayDTO dto = new EssayDTO();
        when(essayService.update(dto)).thenReturn(dto);
        ResponseEntity<?> response = essayController.updateEssay(dto);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testDeleteEssay() {
        EssayDTO dto = new EssayDTO();
        dto.setEssayId("1");
        when(essayService.delete("1")).thenReturn(dto);
        ResponseEntity<?> response = essayController.deleteEssay(dto);
        assertEquals(200, response.getStatusCodeValue());
    }
}