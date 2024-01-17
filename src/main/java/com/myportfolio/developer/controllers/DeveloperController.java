package com.myportfolio.developer.controllers;

import com.myportfolio.developer.dtos.DeveloperDTO;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("developers")
public class DeveloperController {

  @Autowired
  private DeveloperService developerService;
  @GetMapping
  public ResponseEntity<List<Developer>> getDeveloper () {
    return new ResponseEntity<>(this.developerService.getAllDevelopers(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Developer> createDeveloper (@RequestBody DeveloperDTO data) throws Exception {
    Developer newDeveloper = this.developerService.createDeveloper(data);

    return new ResponseEntity<>(newDeveloper, HttpStatus.CREATED);
  }
}
