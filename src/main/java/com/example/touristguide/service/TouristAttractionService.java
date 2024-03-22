package com.example.touristguide.service;


import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.model.TouristAttractionDB;
import com.example.touristguide.repository.TouristAttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristAttractionService {

    public final TouristAttractionRepository touristAttractionRepository;

    public TouristAttractionService(TouristAttractionRepository touristAttractionRepository) {
        this.touristAttractionRepository = touristAttractionRepository;
    }

    public List<TouristAttractionDB> getAllTouristAttractions() {
        return touristAttractionRepository.findAll();
    }
}
