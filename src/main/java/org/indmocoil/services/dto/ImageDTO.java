package org.indmocoil.services.dto;

import com.google.cloud.datastore.Blob;
import com.google.cloud.spring.data.datastore.core.mapping.Unindexed;
import lombok.Data;

@Data
public class ImageDTO {
    private String imageId;
    private String mimeType;
    private Blob Image;
}
