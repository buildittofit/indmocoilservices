package org.indmocoil.services.service;

import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.entities.Essay;
import org.indmocoil.services.repositories.EssayRepository;
import org.indmocoil.services.repositories.EssayRepositoryTemplate;
import org.indmocoil.services.services.EssayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EssayServiceImplTest {

    private EssayRepositoryTemplate essayRepositoryTemplate;
    private EssayRepository essayRepository;
    private ModelMapper modelMapper;
    private EssayServiceImpl essayService;

    @BeforeEach
    void setUp() {
        essayRepositoryTemplate = mock(EssayRepositoryTemplate.class);
        essayRepository = mock(EssayRepository.class);
        modelMapper = new ModelMapper();
        essayService = new EssayServiceImpl(essayRepositoryTemplate, modelMapper);
        essayService.essayRepository = essayRepository;
    }

    @Test
    void testGetAll() {
        Essay essay = new Essay();
        when(essayRepository.findAll()).thenReturn(Collections.singletonList(essay));
        List<EssayDTO> result = essayService.getAll();
        assertNotNull(result);
    }

    @Test
    void testGetById() {
        Essay essay = new Essay();
        when(essayRepositoryTemplate.findByEssayId("1")).thenReturn(essay);
        EssayDTO dto = essayService.getById("1");
        assertNotNull(dto);
    }

    @Test
    void testGetByHeading() {
        Essay essay = new Essay();
        when(essayRepositoryTemplate.findByHeading("heading")).thenReturn(Collections.singletonList(essay));
        List<EssayDTO> result = essayService.getByHeading("heading");
        assertNotNull(result);
    }

    @Test
    void testGetDistinctHeadings() {
        Essay essay = new Essay();
        essay.setHeading("heading");
        when(essayRepository.findAllheadings()).thenReturn(Collections.singletonList(essay));
        List<String> result = essayService.getDistinctHeadings();
        assertNotNull(result);
    }

    @Test
    void testSave() {
        EssayDTO dto = new EssayDTO();
        dto.setEssayId("1");
        Essay essay = new Essay();
        when(essayRepositoryTemplate.saveEssay(any(Essay.class))).thenReturn(essay);
        EssayDTO result = essayService.save(dto);
        assertNotNull(result);
    }

    @Test
    void testUpdate() {
        EssayDTO dto = new EssayDTO();
        dto.setEssayId("1");
        Essay essay = new Essay();
        when(essayRepositoryTemplate.findById("1")).thenReturn(essay);
        when(essayRepositoryTemplate.saveEssay(any(Essay.class))).thenReturn(essay);
        EssayDTO result = essayService.update(dto);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        Essay essay = new Essay();
        when(essayRepositoryTemplate.findById("1")).thenReturn(essay);
        when(essayRepositoryTemplate.deleteEssay(essay)).thenReturn(essay); // Fix here
        EssayDTO result = essayService.delete("1");
        assertNotNull(result);

    }
}