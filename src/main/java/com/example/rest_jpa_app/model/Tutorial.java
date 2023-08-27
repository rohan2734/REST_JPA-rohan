package com.example.rest_jpa_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Tutorial_Data")
@Data
@NoArgsConstructor

public class Tutorial {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="Tut_Title")
    String title;
    @Column(name="Tut_Author")
    String author;
    boolean published;
    @CreationTimestamp
    LocalDateTime create_time;
    @UpdateTimestamp
    LocalDateTime update_time;


    public Tutorial(String title, String author, boolean published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }
}
