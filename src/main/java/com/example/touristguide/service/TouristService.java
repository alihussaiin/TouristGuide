package service;

import model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TouristRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository repository;

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
    public TouristAttraction getAttractionByName(String name) {
        return repository.getAttractionByName(name);
    }

}
