package com.example.touristguide.service;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {


    private final  TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getAllAttractions() {
        List<TouristAttraction> attractionsList = repository.getAttractionsList();
        return new ArrayList<>(attractionsList);
    }

    public TouristAttraction createAttraction(TouristAttraction attraction) {
        return repository.updateAttraction(attraction);
    }

    public TouristAttraction updateAttractionByDescription(String description, TouristAttraction attraction) {
        return repository.update(description, attraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return repository.update(attraction.getDescription(), attraction);
    }

    public boolean deleteAttractionByDescription(String description) {
        repository.deleteByDescription(description);
        // Returner altid true for nu
        return true;
    }


    public List<TouristAttraction> getAttractionsByName(String name) {
        return repository.getByName(name);
    }

    public TouristAttraction getAttractionByDescription(String description) {
        return repository.getByDescription(description);
    }

    // Ny metode til at hente turistattraktion ud fra navn
    public TouristAttraction getAttractionByName(String name) {
        return repository.getAttractionByName(name);
        // Antager, at navnet er unikt og gemt i description
    }

    // Ny metode til at hente tags for en turistattraktion ud fra navn
    public List<String> getAttractionTagsByName(String name) {
        return repository.getAllTagsByName(name);
    }
    public String getEditAttractionPage(String name) {
        TouristAttraction attraction = repository.getAttractionByName(name);
        if (attraction != null) {
            // Formater attraktionens data til redigeringssiden
            String editPageContent = "Edit Page for: " + attraction.getName() + "\n";
            editPageContent += "Description: " + attraction.getDescription();
            return editPageContent;
        } else {
            // Returner null eller en fejlmeddelelse, hvis attraktionen ikke blev fundet
            return null;
        }
    }

}
