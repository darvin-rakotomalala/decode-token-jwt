package com.poc.service;

import com.poc.dto.UserInformationDTO;

public interface UserRSA {
    UserInformationDTO getUserInformation(String bearerToken);
}
