package com.atamertc.service;

import com.atamertc.repository.IGenreRepository;
import com.atamertc.repository.entity.Genre;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends ServiceManager<Genre,Long> {
    private final IGenreRepository genreRepository;


    public GenreService(IGenreRepository genreRepository) {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }

}
