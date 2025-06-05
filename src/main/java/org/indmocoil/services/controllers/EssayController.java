package org.indmocoil.services.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.indmocoil.services.dto.EssayDTO;
import org.indmocoil.services.services.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/essays")
@RequiredArgsConstructor
public class EssayController {

    @Autowired
    EssayService essayService;

    @GetMapping
    public ResponseEntity<List<EssayDTO>> getAllEssays() {
        return new ResponseEntity<List<EssayDTO>>(essayService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/headings")
    public  ResponseEntity<List<String>> getDistinctHeadings() {
        return new ResponseEntity<List<String>>(essayService.getDistinctHeadings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EssayDTO> getEssayById(@PathVariable("id") String id) {
        return new ResponseEntity<EssayDTO>(essayService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/heading/{heading}")
    public ResponseEntity<List<EssayDTO>> getEssaysByHeading(@PathVariable("heading")String heading) {
        return new ResponseEntity<List<EssayDTO>>(essayService.getByHeading(heading), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EssayDTO> saveEssay(@RequestBody EssayDTO essayDTO){
        return new ResponseEntity<EssayDTO>(essayService.save(essayDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EssayDTO> updateEssay(@RequestBody EssayDTO essayDTO){
        log.info("IN UPDATE");
        return new ResponseEntity<EssayDTO>(essayService.update(essayDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<EssayDTO> deleteEssay(@RequestBody EssayDTO essayDTO){
        return new ResponseEntity<EssayDTO>(essayService.delete(essayDTO.getEssayId()), HttpStatus.OK);
    }

}
