package org.indmocoil.services.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.dto.ImageDTO;
import org.indmocoil.services.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageDTO> saveImage(@RequestBody MultipartFile img) throws IOException {
        log.info("IN saveImage");
        return new ResponseEntity<ImageDTO>(imageService.save(img), HttpStatus.OK);
    }

    @PostMapping("/imageupload")
    public ResponseEntity<ImageDTO> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
         return new ResponseEntity<ImageDTO>(imageService.save(file), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        return new ResponseEntity<List<ImageDTO>>(imageService.getAllImages(), HttpStatus.OK);
    }

    @GetMapping("/{imageid}")
    public ResponseEntity<byte[]> fetchImage(@PathVariable String imageid){
        HttpHeaders headers = new HttpHeaders();
        ImageDTO img = imageService.getImageById(imageid);

        switch(img.getMimeType()) {
            case "image/png":
                headers.setContentType(MediaType.IMAGE_PNG);
                break;
            case "image/gif":
                headers.setContentType(MediaType.IMAGE_GIF);
                break;
            default:
                headers.setContentType(MediaType.IMAGE_JPEG);
                break;
        }


        return new ResponseEntity<>(img.getImage().toByteArray(), headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImageDTO> deleteImage(@PathVariable("id")String id){
        return new ResponseEntity<ImageDTO>(imageService.delete(id), HttpStatus.OK);
    }


}
