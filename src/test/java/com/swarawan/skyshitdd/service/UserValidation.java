package com.swarawan.skyshitdd.service;

import com.swarawan.skyshitdd.database.repository.UserDataRepository;
import com.swarawan.skyshitdd.model.RegistrationRequestModel;
import com.swarawan.skyshitdd.model.RegistrationResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserValidation {

    @Mock
    private UserDataRepository repository;

    @InjectMocks
    private UserServiceImpl service;

    @BeforeAll
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEmptyRequest() {
        RegistrationRequestModel request = new RegistrationRequestModel();
        Assertions.assertThrows(Exception.class, () -> {
            service.doRegistration(request);
        });
    }

    @Test
    public void testNullEmail() {
        RegistrationRequestModel request = new RegistrationRequestModel();
        request.setEmail(null);

        Assertions.assertThrows(Exception.class, () -> {
            service.doRegistration(request);
        });
    }

    @Test
    public void testEmptyEmail() {
        RegistrationRequestModel request = new RegistrationRequestModel();
        request.setEmail("");

        Assertions.assertThrows(Exception.class, () -> {
            service.doRegistration(request);
        });
    }

    @Test
    public void testDuplicateEmail() {
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

        RegistrationRequestModel request = new RegistrationRequestModel();
        request.setEmail("masbejo@example.com");

        Assertions.assertThrows(Exception.class, () -> {
            service.doRegistration(request);
        });
    }

    @Test
    public void testSuccessCase() throws Exception {
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

        RegistrationRequestModel request = new RegistrationRequestModel();
        request.setEmail("masbejo@example.com");
        request.setName("Mas Bejo");
        request.setPassword("Sun dulu dong");

        RegistrationResponseModel expectedResult = service.doRegistration(request);
        Assertions.assertNotNull(expectedResult.getAccessToken());
    }

    @Test
    public void testEmptyName() {
        RegistrationRequestModel request = new RegistrationRequestModel();
        request.setEmail("masbejo@example.com");
        request.setName("");
        request.setPassword("Sun dulu dong");

        Assertions.assertThrows(Exception.class, () -> {
            service.doRegistration(request);
        });
    }
}
