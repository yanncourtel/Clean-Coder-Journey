package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TripRepository {
    public TripRepository() {
    }

    protected List<Trip> getTripByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }
}