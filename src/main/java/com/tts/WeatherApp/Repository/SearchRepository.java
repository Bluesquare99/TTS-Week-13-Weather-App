package com.tts.WeatherApp.Repository;

import com.tts.WeatherApp.Model.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<Search, Long> {

}

