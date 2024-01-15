package com.myportfolio.experience.dtos;

import java.util.Date;

public record ExperienceDTO(String title, String caption, Date dateStart, Date dateEnd, Long developerId) {}