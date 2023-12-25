//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.SessionManagment;

public class SessionManager {
    private static SessionManager instance;
    private User CurrentUser;

    public SessionManager() {
    }

    public SessionManager(com.example.studenthousing_v1_01.SessionManagment.User currentUser) {
        this.CurrentUser = currentUser;
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    public void startSession(User user) {
        this.CurrentUser = user;
    }

    public void endSession() {
        this.CurrentUser = null;
    }

    public User getCurrentUser() {
        return this.CurrentUser;
    }

    public boolean isLoggedIn() {
        return this.CurrentUser != null;
    }
}
