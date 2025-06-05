package org.indmocoil.services.controllers;

import com.google.cloud.datastore.Blob;
import org.indmocoil.services.dto.ImageDTO;
import org.indmocoil.services.services.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImageControllerTest {

    @Mock
    private ImageService imageService;

    @InjectMocks
    private ImageController imageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllImages() {
        when(imageService.getAllImages()).thenReturn(Collections.emptyList());
        ResponseEntity<?> response = imageController.getAllImages();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetImageById() {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageId("1");
        imageDTO.setMimeType("image/png");
        imageDTO.setImage(Blob.copyFrom("image data".getBytes()));
        when(imageService.getImageById("1")).thenReturn(imageDTO);
        ResponseEntity<?> response = imageController.fetchImage("1");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testSaveImage() throws IOException {
        MultipartFile multipartFile = mock(MultipartFile.class);
        ImageDTO dto = new ImageDTO();
        when(imageService.save(multipartFile)).thenReturn(dto);
        ResponseEntity<?> response = imageController.saveImage(multipartFile);
        assertEquals(200, response.getStatusCodeValue());
    }


    @Test
    void testDeleteImage() {
        ImageDTO dto = new ImageDTO();
        dto.setImageId("1");
        when(imageService.delete("1")).thenReturn(dto);
        ResponseEntity<?> response = imageController.deleteImage(String.valueOf(dto));
        assertEquals(200, response.getStatusCodeValue());
    }
}