package org.indmocoil.services.entities;

import com.google.cloud.datastore.Blob;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Unindexed;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Image {
    @Id
    private String imageId;
    private String mimeType;
    @Unindexed
    private Blob image;
}
