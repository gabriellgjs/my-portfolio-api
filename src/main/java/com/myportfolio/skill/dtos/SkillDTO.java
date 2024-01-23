package com.myportfolio.skill.dtos;

import jakarta.validation.constraints.NotBlank;

public record SkillDTO(
    @NotBlank(message = "Nome não informado")
    String name)
{}
