package com.swarawan.skyshitdd.controller;

import com.swarawan.skyshitdd.model.RegistrationRequestModel;
import com.swarawan.skyshitdd.model.RegistrationResponseModel;
import com.swarawan.skyshitdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody RegistrationRequestModel request) throws Exception {
        RegistrationResponseModel response = userService.doRegistration(request);
        return ResponseEntity.ok(response);
    }
}
