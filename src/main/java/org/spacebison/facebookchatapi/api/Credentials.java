package org.spacebison.facebookchatapi.api;

/**
 * Created by cmb on 22.05.16.
 */
public class Credentials {
    private String mEmail;
    private String mPassword;

    public Credentials(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }
}
