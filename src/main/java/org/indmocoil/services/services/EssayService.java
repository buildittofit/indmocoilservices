package org.indmocoil.services.services;

import org.hibernate.annotations.Comment;
import org.indmocoil.services.dto.EssayDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EssayService {

    List<EssayDTO> getAll();
    EssayDTO getById(String id);
    List<EssayDTO> getByHeading(String heading);
    List<String> getDistinctHeadings();
    EssayDTO save(EssayDTO essayDTO);
    EssayDTO update(EssayDTO essayDTO);
    EssayDTO delete(String id);
}
