package com.example.touristguide.repository;

import com.example.touristguide.model.Tag;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.model.TouristAttractionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristAttractionRepository extends JpaRepository<TouristAttractionDB, Integer> {
}
