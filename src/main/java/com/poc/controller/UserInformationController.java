package com.poc.controller;

import com.poc.dto.UserInformationDTO;
import com.poc.service.UserRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "tokenJwt")
public class UserInformationController {

    private final UserRSA userRSA;

    @Operation(summary = "WS used to decode bearer token jwt")
    @GetMapping("/decode")
    public UserInformationDTO getUserInformation(
            @RequestHeader("Authorization") String bearerToken) {
        return userRSA.getUserInformation(bearerToken);
    }

}
