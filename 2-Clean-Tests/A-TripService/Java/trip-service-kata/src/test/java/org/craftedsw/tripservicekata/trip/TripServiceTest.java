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

    private TripService getService(User loggedUser) {
        return new TripService() {
            @Override
            protected User getLoggedUser() {
                return loggedUser;
            }
        };
    }
}
