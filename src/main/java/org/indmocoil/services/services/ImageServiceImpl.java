package org.indmocoil.services.services;

import com.google.cloud.datastore.Blob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.dto.ImageDTO;
import org.indmocoil.services.entities.Essay;
import org.indmocoil.services.entities.Image;
import org.indmocoil.services.repositories.ImageRepository;
import org.indmocoil.services.repositories.ImageRepositoryTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageRepositoryTemplate imageRepositoryTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public ImageRepository imageRepository;

    @Override
    public List<ImageDTO> getAllImages() {
        Iterable<Image> iterable = imageRepository.findAll();
        List<Image> images = (List<Image>) StreamSupport.stream(iterable.spliterator(), false)
                .toList();
        return images.stream().map(image -> modelMapper.map(image, ImageDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ImageDTO getImageById(String id) {
        Image image = imageRepositoryTemplate.findByImageId(id);
        return modelMapper.map(image, ImageDTO.class);
    }

    @Override
    public ImageDTO save(MultipartFile img) throws IOException {
        Image image = new Image();
        Blob iblob = Blob.copyFrom(img.getBytes());
        UUID uuid = UUID.randomUUID();
        image.setMimeType(img.getContentType());
        image.setImageId(String.valueOf(uuid));
        image.setImage(iblob);
        imageRepositoryTemplate.saveImage(image);
        ImageDTO imageDTO = modelMapper.map(image, ImageDTO.class);
        return imageDTO;

    }

    @Override
    public ImageDTO update(ImageDTO imageDTO) {
        return null;
    }

    @Override
    public ImageDTO delete(String id) {
        Image image = imageRepositoryTemplate.findByImageId(id);
        imageRepositoryTemplate.deleteImage(image);
        return modelMapper.map(image, ImageDTO.class);
    }
}
