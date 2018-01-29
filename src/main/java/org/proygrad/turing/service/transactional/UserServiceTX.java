package org.proygrad.turing.service.transactional;

import org.proygrad.turing.api.scenario.ScenarioTO;
import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.persistence.dao.UserDAO;
import org.proygrad.turing.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceTX {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;


    public UserTO getUser(String id) {
        return userMapper.toTransferObject(userDAO.load(id));
    }

    public String addUser(UserTO userTO) {
        UserEntity entity = userMapper.toEntity(userTO);

        userDAO.save(entity);

        return entity.getId();
    }

    public String updateUser(UserTO userTO) {
        UserEntity entity = userDAO.load(userTO.getId());

        if(entity!=null){
            entity.setName(userTO.getName());

            return entity.getId();
        }

        return null;
    }

    public List<ScenarioTO> getUserScenario(String id) {
        return userMapper.toTransferObject(userDAO.load(id)).getScenarios();
    }
}
