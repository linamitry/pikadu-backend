package com.service.pikadu.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    public String email;
    public String password;
    public String displayName;
}
