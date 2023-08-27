package com.example.rest_jpa_app.controller;

import com.example.rest_jpa_app.model.Tutorial;
import com.example.rest_jpa_app.service.TutorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TutorialController {

    @Autowired
    TutorialServiceImpl tutorialService;

    // localhost:8080/api/v1/tutorials/1
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> findById (@PathVariable long id)
    {
            Tutorial tutorial = tutorialService.findById(id);
             return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    // localhost:8080/api/v1/tutorials
    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> findAll ()
    {
        return  new ResponseEntity<>(tutorialService.findAll() , HttpStatus.OK);
    }

    // localhost:8080/api/v1/tutorials
    @PostMapping
    public ResponseEntity<Tutorial> createTutorial ( @RequestBody Tutorial tutorial)
    {
            Tutorial tutorial1 = tutorialService.createTutorial(tutorial);
            return new ResponseEntity<>(tutorial1,HttpStatus.CREATED);
    }

    // localhost:8080/api/v1/tutorials/update/1
    @PutMapping("/tutorials/update/{id}")
    public ResponseEntity<Tutorial> updateTutorial ( @PathVariable long id , @RequestBody Tutorial tutorial)
    {
        Tutorial t = tutorialService.updateTutorial(id,tutorial);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    // localhost:8080/api/v1/tutorials/delete/1
    @DeleteMapping("/tutorials/delete/{id}")
    public ResponseEntity deleteTutorial ( @PathVariable long id)
    {
        tutorialService.deleteTutorial(id);
        return  new ResponseEntity(HttpStatus.OK);
    }


    // localhost:8080/api/v1/tutorials/1
    @GetMapping("/tutorials/findbypublished/{flag}")
    public ResponseEntity<List<Tutorial>> findByPublished (@PathVariable boolean flag)
    {
        List<Tutorial> tutorial = tutorialService.findAllPublished(flag);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    // localhost:8080/api/v1/tutorials/1
    @GetMapping("/tutorials/findbykeyword")
    public ResponseEntity<List<Tutorial>> findByKeyword (@RequestParam String keyword)
    {
        List<Tutorial> tutorial = tutorialService.findAllContainsKeyword(keyword);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

}
