package com.example.touristguide.repository;

import model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions.add(new TouristAttraction("Parken", "FCK, Danmarks største fodboldhold´s stadion"));
        attractions.add(new TouristAttraction("Tivoli", "Forlystelsespark i øjet af København"));
        attractions.add(new TouristAttraction("Fields", "Stor og flot shoppingcenter i København S"));
        attractions.add(new TouristAttraction("Strøget", "Walking street i hjertet af København"));
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getDescription().equalsIgnoreCase(attraction.getDescription())) {
                attractions.set(i, attraction);
                return attraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> getAll() {
        return attractions;
    }

    public TouristAttraction getByDescription(String description) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getDescription().equalsIgnoreCase(description)) {
                return attraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> getByName(String name) {
        List<TouristAttraction> attractionsByName = new ArrayList<>();
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attractionsByName.add(attraction);
            }
        }
        return attractionsByName;
    }

    public TouristAttraction update(String description, TouristAttraction updatedAttraction) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getDescription().equalsIgnoreCase(description)) {
                attraction.setName(updatedAttraction.getName());
                return attraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> getAttractionsList() {
        return attractions;
    }

    public void deleteByDescription(String description) {
        attractions.removeIf(attraction -> attraction.getDescription().equalsIgnoreCase(description));
    }
    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

}
