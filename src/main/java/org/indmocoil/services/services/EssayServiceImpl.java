package org.indmocoil.services.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.entities.Essay;
import org.indmocoil.services.repositories.EssayRepository;
import org.indmocoil.services.repositories.EssayRepositoryTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class EssayServiceImpl implements EssayService{

    private final EssayRepositoryTemplate essayRepositoryTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public EssayRepository essayRepository;

    @Override
    public List<EssayDTO> getAll() {
        Iterable<Essay> iterable = essayRepository.findAll();
        List<Essay> essays = (List<Essay>) StreamSupport.stream(iterable.spliterator(), false)
                .toList();
        return essays.stream().map(essay -> modelMapper.map(essay, EssayDTO.class)).collect(Collectors.toList());
    }


    @Override
    public EssayDTO getById(String id) {

        Essay essay = essayRepositoryTemplate.findByEssayId(id);
        return modelMapper.map(essay, EssayDTO.class);
    }

    @Override
    public List<EssayDTO> getByHeading(String heading) {

        Iterable<Essay> iterable = essayRepositoryTemplate.findByHeading(heading);
        List<Essay> essays = (List<Essay>) StreamSupport.stream(iterable.spliterator(), false)
                .toList();
        return essays.stream().map(essay -> modelMapper.map(essay, EssayDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<String> getDistinctHeadings() {
        Iterable<Essay> iterable = essayRepository.findAllheadings();
        List<Essay> essays = (List<Essay>) StreamSupport.stream(iterable.spliterator(), false)
                .toList();
        return essays.stream().map(essay -> modelMapper.map(essay.getHeading(), String.class)).collect(Collectors.toList());
    }

    @Override
    public EssayDTO save(EssayDTO essayDTO) {
        Essay essay = modelMapper.map(essayDTO, Essay.class);
        essay.setEssayId(essayDTO.getEssayId());
        essay.setStatus(essayDTO.getStatus());
        essay.setEssaytext(essayDTO.getEssaytext());
        essay.setHeading(essayDTO.getHeading());
        essay.setHeadLine(essayDTO.getHeadLine());
        essay.setSubheading(essayDTO.getSubheading());
        essay.setInputdtm(new Date());
        essay = essayRepositoryTemplate.saveEssay(essay);
        essayDTO = modelMapper.map(essay, EssayDTO.class);
        return essayDTO;
    }

    @Override
    public EssayDTO update(EssayDTO essayDTO) throws IllegalArgumentException{
        Essay essay = essayRepositoryTemplate.findById(essayDTO.getEssayId());
        essay.setStatus(essayDTO.getStatus());
        essay.setEssaytext(essayDTO.getEssaytext());
        essay.setHeading(essayDTO.getHeading());
        essay.setHeadLine(essayDTO.getHeadLine());
        essay.setSubheading(essayDTO.getSubheading());
        essay.setInputdtm(new Date());

        essayRepositoryTemplate.saveEssay(essay);
        return essayDTO;
    }

    @Override
    public EssayDTO delete(String id) throws IllegalArgumentException{
        Essay essay = essayRepositoryTemplate.findById(id);
        essayRepositoryTemplate.deleteEssay(essay);
        return modelMapper.map(essay, EssayDTO.class);

    }
}
