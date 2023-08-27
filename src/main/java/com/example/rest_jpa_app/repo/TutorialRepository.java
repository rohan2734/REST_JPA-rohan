package com.example.rest_jpa_app.repo;

import com.example.rest_jpa_app.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {

    List<Tutorial> findAllByPublished ( boolean flag);
    List<Tutorial>  findByTitleContaining ( String keyword);
}
