package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripServiceTest {
	
    @Test
    void loggedUserWithoutFriendsShouldHaveNoTrip() {
        // Given
        User user = new User();

        TripService service = new TripService() {
            @Override
            protected User getLoggedUser() {
                return new User();
            }
        };
        
        // When
        List<Trip> actualTrips = service.getTripsByUser(user);
        
        // Then
        Assertions.assertTrue(actualTrips.isEmpty(), "Trip list should be empty");
    }
}
