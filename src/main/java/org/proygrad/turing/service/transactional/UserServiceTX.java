package org.proygrad.turing.service.transactional;

import org.apache.log4j.Logger;
import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.persistence.dao.UserDAO;
import org.proygrad.turing.persistence.entities.user.UserEntity;
import org.proygrad.turing.rest.exception.NotFoundException;
import org.proygrad.turing.service.transactional.mapper.UserMapper;
import org.proygrad.turing.service.transactional.mapper.UserPreferencesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceTX {


    private static final Logger LOGGER = Logger.getLogger(UserServiceTX.class);


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPreferencesMapper userPreferencesMapper;


    public UserTO getUser(String id) {
        LOGGER.info("Reading user: " + id);
        UserEntity user = userDAO.load(id);
        if (user != null) {
            LOGGER.info("User readed: " + id);
            return userMapper.toTransferObject(user);
        }
        throw new NotFoundException();
    }

    public String addUser(UserTO userTO) {

        LOGGER.info("Saving user...");
        UserEntity entity = userMapper.toEntity(userTO);
        userDAO.save(entity);
        LOGGER.info("User saved: " + entity.getId());
        return entity.getId();
    }

    public String updateUser(String id, UserTO userTO) {
        LOGGER.info("Updating user: " + id);
        UserEntity entity = userDAO.load(id);

        if (entity != null) {
            entity.setName(userTO.getName());
            entity.setEmail(userTO.getEmail());
            entity.setSurname(userTO.getSurname());
            entity.setOrganization(userTO.getOrganization());
            entity.setPreferences(userPreferencesMapper.toEntity(userTO.getPreferences()));
            userDAO.save(entity);
            LOGGER.info("User updated: " + id);
            return entity.getId();
        }

        throw new NotFoundException();
    }

    public UserTO getUserByEmail(String email) {
        LOGGER.info("Reading user by email: " + email);
        UserEntity user = userDAO.getUserByEmail(email);
        if (user != null) {
            LOGGER.info("User readed: " + email);
            return userMapper.toTransferObject(user);
        }
        throw new NotFoundException();
    }
}
