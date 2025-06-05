package org.indmocoil.services.services;

import org.indmocoil.services.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    List<ImageDTO> getAllImages();
    ImageDTO getImageById(String id);
    ImageDTO save(MultipartFile img) throws IOException;
    ImageDTO update(ImageDTO imageDTO);
    ImageDTO delete(String id);
}
