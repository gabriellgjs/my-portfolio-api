package com.myportfolio.experience.dtos;

import java.util.Date;
import java.util.Optional;

public record ExperienceDTO(String title, String caption, Date dateStart, Optional<Date> dateEnd, Long developerId) {}