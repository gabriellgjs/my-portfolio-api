package com.myportfolio.skill.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Optional;

public record SkillDTO(
    Optional<Long>id,

    @NotBlank(message = "Nome não informado")
    String name)
{}
