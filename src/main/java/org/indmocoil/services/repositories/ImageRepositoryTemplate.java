package org.indmocoil.services.repositories;

import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import org.indmocoil.services.entities.Essay;
import org.indmocoil.services.entities.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageRepositoryTemplate {
    private final DatastoreTemplate datastoreTemplate;
    public ImageRepositoryTemplate(DatastoreTemplate datastoreTemplate) {
        this.datastoreTemplate = datastoreTemplate;
    }

    public Image saveImage(Image image){
        datastoreTemplate.save(image);
        return image;
    }

    public Image findByImageId(String id){
        return datastoreTemplate.findById(id, Image.class);
    }

    public Image deleteImage(Image image){
        datastoreTemplate.delete(image);
        return image;
    }

}
