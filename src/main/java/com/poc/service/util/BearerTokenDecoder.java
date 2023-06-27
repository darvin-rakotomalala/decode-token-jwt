package com.poc.service.util;

import com.poc.dto.UserInformationDTO;
import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class BearerTokenDecoder {

    public BearerTokenDecoder() {
        // TODO document why this constructor is empty
    }

    public static UserInformationDTO getUserInformation(String bearerToken) {

        if (bearerToken == null) {
            throw new FunctionalException(ErrorsEnum.ERR_USER_TOKEN_NOT_FOUND.getErrorMessage());
        } else {

            try {
                String[] chunks = bearerToken.split("\\.");
                Base64.Decoder decoder = Base64.getUrlDecoder();
                String payload = new String(decoder.decode(chunks[1]));
                JSONObject jsonPayload = new JSONObject(payload);

                String userIPN = jsonPayload.getString("uid");
                String userProfile = jsonPayload.getString("role-ct1-irn72529");
                List<String> userProfilList = Arrays.asList(userProfile.replaceAll("\\[|\\]| ", "").split("\\,"));

                UserInformationDTO userInformationDTO = new UserInformationDTO();
                userInformationDTO.setUserIpn(userIPN);
                userInformationDTO.setUserProfile(userProfilList);
                return userInformationDTO;

            } catch (Exception e) {
                throw new FunctionalException(ErrorsEnum.ERR_USER_EXCEPTION.getErrorMessage());
            }
        }
    }
}
