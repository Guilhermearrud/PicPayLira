package com.picpaylira.picpayLira.dtos;

import com.picpaylira.picpayLira.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
}
