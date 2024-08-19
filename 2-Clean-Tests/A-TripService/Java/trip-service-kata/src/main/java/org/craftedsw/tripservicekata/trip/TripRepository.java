package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public interface TripRepository {
    List<Trip> findTripsByUser(User user);
}