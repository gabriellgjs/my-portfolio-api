package com.myportfolio.education.dtos;

import com.myportfolio.education.enums.SituationType;

import java.util.Date;

public record EducationDTO(String course, String institution, SituationType situation, Date dateStart, Date dateEnd, Long developerId) {}
