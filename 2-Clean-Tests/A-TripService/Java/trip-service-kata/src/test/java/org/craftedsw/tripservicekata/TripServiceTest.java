package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    @InjectMocks
    TripService service;

    @Mock
    UserSession userSession;

    @Test
    void getTripsByUser_isNotAllowed_ifUserIsNotLogged() {
        //Arrange
        when(userSession.getLoggedUser()).thenReturn(null);
        //Act Assert
        assertThrows(UserNotLoggedInException.class, () -> service.getTripsByUser(new User()));
    }
}