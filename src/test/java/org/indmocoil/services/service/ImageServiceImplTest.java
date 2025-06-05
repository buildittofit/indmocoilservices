package org.indmocoil.services.service;
import org.indmocoil.services.dto.ImageDTO;
import org.indmocoil.services.entities.Image;
import org.indmocoil.services.repositories.ImageRepository;
import org.indmocoil.services.repositories.ImageRepositoryTemplate;
import org.indmocoil.services.services.ImageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ImageServiceImplTest {
    private ImageRepositoryTemplate imageRepositoryTemplate;
    private ImageRepository imageRepository;
    private ModelMapper modelMapper;
    private ImageServiceImpl imageService;

    @BeforeEach
    void setUp() {
        imageRepositoryTemplate = mock(ImageRepositoryTemplate.class);
        imageRepository = mock(ImageRepository.class);
        modelMapper = new ModelMapper();
        imageService = new ImageServiceImpl(imageRepositoryTemplate, modelMapper);
        imageService.imageRepository = imageRepository;
    }

    @Test
    void testGetAll() {
        Image image = new Image();
        when(imageRepository.findAll()).thenReturn(Collections.singletonList(image));
        List<ImageDTO> result = imageService.getAllImages();
        assertNotNull(result);
    }

    @Test
    void testGetById() {
        Image image = new Image();
        when(imageRepositoryTemplate.findByImageId("1")).thenReturn(image);
        ImageDTO dto = imageService.getImageById("1");
        assertNotNull(dto);
    }

}
