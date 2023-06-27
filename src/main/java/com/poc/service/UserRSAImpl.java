package com.poc.service;

import com.poc.dto.UserInformationDTO;
import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.service.util.BearerTokenDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRSAImpl implements UserRSA {

    @Override
    public UserInformationDTO getUserInformation(String bearerToken) {
        UserInformationDTO userInformation = BearerTokenDecoder.getUserInformation(bearerToken);
        if (userInformation.getUserIpn() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_USER_IPN_EMPTY.getErrorMessage());
        }
        return userInformation;
    }
}
