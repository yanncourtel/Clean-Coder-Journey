package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripServiceWithMock extends TripService {


    private List<Trip> mockTrips;

    @Override
    protected List<Trip> getTrips(User user) {
        return mockTrips;
    }

    public void setMockTrips(List<Trip> trips) {
        this.mockTrips = trips;
    }
}
