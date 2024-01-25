package com.myportfolio.resume.controllers;

import com.myportfolio.resume.models.Resume;
import com.myportfolio.resume.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resume")
public class ResumeController {
  @Autowired
  private ResumeService resumeService;

  @GetMapping("/{developerId}")
  public ResponseEntity<Resume> resume(@PathVariable(value = "developerId") Long developerId) {
    return new ResponseEntity<>(this.resumeService.resume( developerId), HttpStatus.OK);
  }
}
