package com.myportfolio.projects.dtos;

import java.util.Optional;

public record ProjectDTO(String title, String caption, String owner, String description, Optional<String> url, Long developerId) {}
