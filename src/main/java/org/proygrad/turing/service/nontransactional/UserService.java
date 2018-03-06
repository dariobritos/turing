package org.proygrad.turing.service.nontransactional;

import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.service.transactional.UserServiceTX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserServiceTX userServiceTX;

    public UserTO getUser( String id) {
        return userServiceTX.getUser(id);
    }

    public String addUser(UserTO userTO) {
        return userServiceTX.addUser(userTO);
    }

    public String updateUser(String id, UserTO userTO) {
        return userServiceTX.updateUser(id, userTO);
    }

    public UserTO getUserByEmail(String email){
        return userServiceTX.getUserByEmail(email);
    }
}
