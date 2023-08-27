package com.example.rest_jpa_app.service;

import com.example.rest_jpa_app.model.Tutorial;

import java.util.List;

public interface TutorialInterface {

    public Tutorial createTutorial ( Tutorial tutorial);
    public Tutorial updateTutorial ( long id , Tutorial tutorial);
    public void deleteTutorial ( long id );
    public Tutorial findById ( long id);
    public List<Tutorial> findAll ( );
    public List<Tutorial> findAllPublished(boolean flag);
    public List<Tutorial> findAllContainsKeyword ( String keyword);

}
