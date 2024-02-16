package com.example.touristguide.controller;

import model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TouristService;

import java.util.List;

@RestController
@RequestMapping("attractions")
public class TouristController {

    @Autowired
    private TouristService touristService;

    // CREATE endpoints
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> createAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction createdAttraction = touristService.createAttraction(attraction);
        return new ResponseEntity<>(createdAttraction, HttpStatus.CREATED);
    }

    // READ endpoints
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }


    @GetMapping("/description/{description}")
    public ResponseEntity<TouristAttraction> getAttractionByDescription(@PathVariable String description) {
        TouristAttraction attraction = touristService.getAttractionByDescription(description);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<TouristAttraction>> getAttractionsByName(@PathVariable String name) {
        List<TouristAttraction> attractions = touristService.getAttractionsByName(name);
        if (!attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // UPDATE endpoints
    @PutMapping("/update/{description}")
    public ResponseEntity<TouristAttraction> updateAttractionByDescription(@PathVariable String description, @RequestBody TouristAttraction attraction) {
        TouristAttraction updatedAttraction = touristService.updateAttractionByDescription(description, attraction);
        if (updatedAttraction != null) {
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction updatedAttraction = touristService.updateAttraction(attraction);
        if (updatedAttraction != null) {
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE endpoints
    @DeleteMapping("/delete/{description}")
    public ResponseEntity<String> deleteAttractionByDescription(@PathVariable String description) {
        boolean deleted = touristService.deleteAttractionByDescription(description);
        if (deleted) {
            return new ResponseEntity<>("Attraktion med beskrivelsen \"" + description + "\" er blevet slettet.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraktion med beskrivelsen \"" + description + "\" blev ikke fundet.", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<String> getAttractionDescriptionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction.getDescription(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraktionen med navnet \"" + name + "\" blev ikke fundet.", HttpStatus.NOT_FOUND);
        }
    }


}

