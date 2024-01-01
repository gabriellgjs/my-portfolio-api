package com.myportfolio.education.dtos;

import com.myportfolio.education.enums.SituationType;

public record EducationDTO(String course, String institution, SituationType situation, Long developerId) {}
