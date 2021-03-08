package com.tts.WeatherApp.Controller;

import com.tts.WeatherApp.Model.Response;
import com.tts.WeatherApp.Model.Search;
import com.tts.WeatherApp.Repository.SearchRepository;
import com.tts.WeatherApp.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private SearchRepository searchRepository;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("search", new Search());
        return "index";
    }

    @PostMapping
    public String postIndex(Search search, Model model) {
        Response data = weatherService.getForecast(search.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }

    @PostMapping("/")
    public String zipCodeSearch(Search search, Model model) {
        searchRepository.save(new Search(search.getId(), search.getZipCode()));
        model.addAttribute("zipcode", search.getZipCode());
        return "index";
    }
}