package com.poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserInformationDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userIpn;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> userProfile;
}
