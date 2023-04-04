package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class UserSession {
    public UserSession() {
    }

    protected User getLoggedUser() {
        User loggedUser = org.craftedsw.tripservicekata.user.UserSession.getInstance().getLoggedUser();
        return loggedUser;
    }
}