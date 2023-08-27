package com.example.rest_jpa_app.service;

import com.example.rest_jpa_app.exceptions.ResourceNotFoundException;
import com.example.rest_jpa_app.model.Tutorial;
import com.example.rest_jpa_app.repo.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialInterface{
    @Autowired
    TutorialRepository repository;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return repository.save(tutorial);
    }

    @Override
    public Tutorial updateTutorial(long id, Tutorial tutorial) {

        Optional<Tutorial> tutorial1 = repository.findById(id);
        if ( tutorial1.isPresent())
        {
                Tutorial newTut = tutorial1.get();
                newTut.setAuthor( tutorial.getAuthor());
                newTut.setTitle( tutorial.getTitle());
                newTut.setPublished( tutorial.isPublished());
                repository.save(newTut);
                return newTut;
        }
        else
            throw  new ResourceNotFoundException();

    }

    @Override
    public void deleteTutorial(long id) {
        Optional<Tutorial> tutorial1 = repository.findById(id);
        if ( tutorial1.isPresent())
        {
            Tutorial newTut = tutorial1.get();
            repository.delete(newTut);
        }
        else
            throw  new ResourceNotFoundException();
    }

    @Override
    public Tutorial findById(long id) {
        Optional<Tutorial> tutorial = repository.findById(id);
        return tutorial.orElseThrow(()->new ResourceNotFoundException());
    }

    @Override
    public List<Tutorial> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Tutorial> findAllPublished(boolean flag) {
        return repository.findAllByPublished(flag);
    }

    @Override
    public List<Tutorial> findAllContainsKeyword(String keyword) {
        return repository.findByTitleContaining(keyword);
    }
}
