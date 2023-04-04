package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripServiceTest {

    @Test
    @DisplayName("A user that is not logged in should not be able to get trips")
    void notLoggedUserTryingToGetTripsShouldFail() {
        // Given
        User user = new User();

        TripService service = getService(null);

        // When & Then
        Assertions.assertThrows(UserNotLoggedInException.class, ()-> service.getTripsByUser(user));
    }

    @Test
    void loggedUserWithoutFriendsShouldHaveNoTrip() {
        // Given
        User user = new User();

        TripService service = getService(new User());

        // When
        List<Trip> actualTrips = service.getTripsByUser(user);
        
        // Then
        Assertions.assertTrue(actualTrips.isEmpty(), "Trip list should be empty");
    }

    @Test
    @DisplayName("A user that has different friend should return empty trip list")
    void loggedUserWithFriendsShouldHaveNoTrip() {
        // Given
        User loggedUser = new User();

        User notfriendOfLoggedUser = new User();

        User friendOfLoggedUser = new User();
        friendOfLoggedUser.getFriends().add(notfriendOfLoggedUser);
        friendOfLoggedUser.addTrip(new Trip());

        TripService service = getService(loggedUser);

        // When
        List<Trip> actualTrips = service.getTripsByUser(friendOfLoggedUser);

        // Then
        Assertions.assertEquals(0, actualTrips.size());
    }

    @Test
    @DisplayName("A user that has friend should return trip list")
    void loggedUserWithFriendsShouldHaveTrip() {
        // Given
        User loggedUser = new User();

        User friendOfLoggedUser = new User();
        friendOfLoggedUser.getFriends().add(loggedUser);
        friendOfLoggedUser.addTrip(new Trip());

        TripService service = getService(loggedUser);

        // When
        List<Trip> actualTrips = service.getTripsByUser(friendOfLoggedUser);

        // Then
        Assertions.assertEquals(1, actualTrips.size());
    }
    private TripService getService(User loggedUser) {
        return new TripService(new TripRepository(){
            @Override
            public List<Trip> getTripByUser(User user) {
                return  user.trips();
            }
        }, new UserSession(){
            @Override
            public User getLoggedUser() {
                return loggedUser;
            }
        }) {};
    }
}
