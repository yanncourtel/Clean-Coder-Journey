package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    @InjectMocks
    TripServiceWithMock service;

    @Mock
    UserSession userSession;

    @Test
    void getTripsByUser_isNotAllowed_ifUserIsNotLogged() {
        //Arrange
        when(userSession.getLoggedUser()).thenReturn(null);
        //Act Assert
        assertThrows(UserNotLoggedInException.class, () -> service.getTripsByUser(new User()));
    }

    @Test
    void getTripsByUser_whenSearchedUserHasNoFriend_isEmpty() {
        //Arrange
        User searchedUser = new User();
        User userLoggedIn = new User();
        when(userSession.getLoggedUser()).thenReturn(userLoggedIn);

        //Act
        List<Trip> trips = service.getTripsByUser(searchedUser);

        //Assert
        Assertions.assertEquals(0, trips.size());
    }

    @Test
    void getTripsByUser_whenLoggedUserisNotFriendWithSearchedUser_isEmpty() {
        //Arrange
        User searchedUser = new User();
        searchedUser.addFriend(new User());
        User userLoggedIn = new User();
        when(userSession.getLoggedUser()).thenReturn(userLoggedIn);

        //Act
        List<Trip> trips = service.getTripsByUser(searchedUser);

        //Assert
        Assertions.assertEquals(0, trips.size());
    }

    @Test
    void getTripsByUser_whenLoggedUserisFriendWithSearchedUser() {
        //Arrange
        User searchedUser = new User();
        List<Trip> mockedTrips = new ArrayList<>();
        mockedTrips.add(new Trip());
        service.setMockTrips(mockedTrips);
        User userLoggedIn = new User();
        when(userSession.getLoggedUser()).thenReturn(userLoggedIn);
        searchedUser.addFriend(userLoggedIn);

        //Act
        List<Trip> trips = service.getTripsByUser(searchedUser);

        //Assert
        Assertions.assertEquals(1, trips.size());
        Assertions.assertEquals(mockedTrips.get(0), trips.get(0));
    }
}