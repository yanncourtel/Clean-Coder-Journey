package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

	private final TripRepository tripRepository;
	private final org.craftedsw.tripservicekata.trip.UserSession userSession;

	public TripService(TripRepository tripRepository, UserSession userSession) {
		this.tripRepository = tripRepository;
		this.userSession = userSession;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = userSession.getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripRepository.getTripByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
}
