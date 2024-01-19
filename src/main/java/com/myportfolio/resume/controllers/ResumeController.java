package com.myportfolio.resume.controllers;

import com.myportfolio.resume.model.Resume;
import com.myportfolio.resume.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resume")
public class ResumeController {
  @Autowired
  private ResumeService resumeService;

  @GetMapping
  public ResponseEntity<Resume> resume() {
    return new ResponseEntity<>(this.resumeService.resume( 1L), HttpStatus.OK);
  }
}
