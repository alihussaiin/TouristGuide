package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {


    private final TouristService touristService;

    public TouristController(TouristService touristService) {

        this.touristService = touristService;
    }

    // CREATE endpoints

    @GetMapping("")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);
        return "attractionList"; // Returnerer navnet på Thymeleaf-skabelonen
    }

    @GetMapping("/add")
    public String createAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.createAttraction(attraction);
        return "redirect:/attractions"; // Redirect til GET /attractions for at vise alle turistattraktioner

    }

    @GetMapping("/description/{description}")
    public String getAttractionByDescription(@PathVariable String description, Model model) {
        TouristAttraction attraction = touristService.getAttractionByDescription(description);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attractionDetails"; // Returnerer navnet på Thymeleaf-skabelonen
        } else {
            return "attractionNotFound"; // Returnerer navnet på Thymeleaf-skabelonen
        }
    }

    @GetMapping("/name/{name}")
    public String getAttractionsByName(@PathVariable String name, Model model) {
        List<TouristAttraction> attractions = touristService.getAttractionsByName(name);
        if (!attractions.isEmpty()) {
            model.addAttribute("attractions", attractions);
            return "attractionList"; // Returnerer navnet på Thymeleaf-skabelonen
        } else {
            return "attractionNotFound"; // Returnerer navnet på Thymeleaf-skabelonen
        }
    }

    // UPDATE endpoints
    @PutMapping("/update/{description}")
    public String updateAttractionByDescription(@PathVariable String description, @ModelAttribute TouristAttraction attraction) {
        touristService.updateAttractionByDescription(description, attraction);
        return "redirect:/attractions"; // Redirect til GET /attractions for at vise alle turistattraktioner
    }

    @PutMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.updateAttraction(attraction);
        return "redirect:/attractions"; // Redirect til GET /attractions for at vise alle turistattraktioner
    }

    // DELETE endpoints
    @DeleteMapping("/delete/{description}")
    public String deleteAttractionByDescription(@PathVariable String description) {
        touristService.deleteAttractionByDescription(description);
        return "redirect:/attractions"; // Redirect til GET /attractions for at vise alle turistattraktioner
    }

    @GetMapping("/{name}")
    public String getAttractionDescriptionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            model.addAttribute("description", attraction.getDescription());
            return "attractionDescription";
        } else {
            return "attractionNotFound";
        }
    }

    @GetMapping("/{name}/tags")
    public String getAttractionTagsByName(@PathVariable String name, Model model) {
        List<String> tags = touristService.getAttractionTagsByName(name);
        if (!tags.isEmpty()) {
            model.addAttribute("tags", tags);
            return "tags";
        } else {
            return "redirect:/attractions";
        }
    }

    @GetMapping("/{name}/edit")
    public String getEditAttractionPage(@PathVariable String name, Model model) {
        String editPageContent = touristService.getEditAttractionPage(name);
        model.addAttribute("editContent", editPageContent);
        return "editPage";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.createAttraction(attraction);
        return "redirect:/attractions";
    }



}