package org.indmocoil.services.dto;

import com.google.cloud.datastore.Blob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageDTOTest {

    @Test
    void testGettersAndSetters() {
        ImageDTO dto = new ImageDTO();
        dto.setImageId("1");
        dto.setMimeType("image/png");
        dto.setImage(Blob.copyFrom("image data".getBytes()));

        assertEquals("1", dto.getImageId());
        assertEquals("image/png", dto.getMimeType());
        assertNotNull(dto.getImage());
        assertArrayEquals("image data".getBytes(), dto.getImage().toByteArray());

    }
}