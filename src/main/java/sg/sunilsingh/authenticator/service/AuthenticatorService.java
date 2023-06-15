package sg.sunilsingh.authenticator.service;

import org.springframework.stereotype.Service;

import sg.sunilsingh.authenticator.model.LoginInfo;

@Service
public class AuthenticatorService {

    public boolean validateLogin(LoginInfo login) {

        String username = login.getUsername();
        String password = login.getPassword();

        if (username.equals("fred") && password.equals("fredfred")) {
            return true;

        } else if (username.equals("barney") && password.equals("barneybarney")) {
            return true;

        } else if (username.equals("wilma") && password.equals("wilmawilma")) {
            return true;

        } else if (username.equals("betty") && password.equals("bettybetty")) {
            return true;

        } else {
            return false;
        }

    }
}
