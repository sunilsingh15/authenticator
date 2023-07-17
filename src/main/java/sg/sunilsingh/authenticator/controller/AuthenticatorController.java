package sg.sunilsingh.authenticator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.sunilsingh.authenticator.model.LoginInfo;
import sg.sunilsingh.authenticator.model.ReturnMessage;
import sg.sunilsingh.authenticator.service.AuthenticatorService;

@RestController
@RequestMapping(path = "/api")
public class AuthenticatorController {

    @Autowired
    AuthenticatorService service;

    @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestBody String payload) {

        LoginInfo info = LoginInfo.create(payload);
        ReturnMessage msg = new ReturnMessage();

        if (service.validateLogin(info)) {
            msg.setMessage("User " + info.getUsername() + " authenticated successfully.");
            return new ResponseEntity<String>(msg.toJSON().toString(), HttpStatus.OK);
        } else {
            msg.setMessage("Invalid user! Please try again.");
            return new ResponseEntity<String>(msg.toJSON().toString(), HttpStatus.UNAUTHORIZED);
        }

    }

}
