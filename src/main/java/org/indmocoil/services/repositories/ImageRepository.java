package org.indmocoil.services.repositories;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.indmocoil.services.entities.Image;

public interface ImageRepository extends DatastoreRepository<Image, String> {

}
