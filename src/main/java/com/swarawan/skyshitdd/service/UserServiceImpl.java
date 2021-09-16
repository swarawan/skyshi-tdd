package com.swarawan.skyshitdd.service;

import com.swarawan.skyshitdd.database.repository.UserDataRepository;
import com.swarawan.skyshitdd.model.RegistrationRequestModel;
import com.swarawan.skyshitdd.model.RegistrationResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDataRepository repository;

    @Override
    public RegistrationResponseModel doRegistration(RegistrationRequestModel request) throws Exception {
        if (request == null) {
            throw new Exception("request body tidak boleh kosong");
        } else if (request.getEmail() == null || request.getEmail().equals("")) {
            throw new Exception("email tidak boleh kosong");
        } else if (request.getName().equals("")) {
            throw new Exception("nama tidak boleh kosong");
        }

        Boolean isDuplicateUser = repository.existsByEmail(request.getEmail());
        if (isDuplicateUser) {
            throw new Exception("data dengan email " + request.getEmail() + " sudah digunakan");
        }

        RegistrationResponseModel response = new RegistrationResponseModel();
        response.setAccessToken("abcd1234");
        return response;
    }

}
