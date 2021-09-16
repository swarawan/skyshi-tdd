package com.swarawan.skyshitdd.service;

import com.swarawan.skyshitdd.model.RegistrationRequestModel;
import com.swarawan.skyshitdd.model.RegistrationResponseModel;

import java.util.Map;

public interface UserService {

    RegistrationResponseModel doRegistration(RegistrationRequestModel request) throws Exception;
}
