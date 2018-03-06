package org.proygrad.turing.service.transactional;

import org.proygrad.turing.api.user.UserTO;
import org.proygrad.turing.persistence.dao.UserDAO;
import org.proygrad.turing.persistence.entities.user.UserEntity;
import org.proygrad.turing.service.transactional.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
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

    public String updateUser(String id, UserTO userTO) {
        UserEntity entity = userDAO.load(id);

        if(entity!=null){
            entity.setName(userTO.getName());
            entity.setEmail(userTO.getEmail());
            entity.setSurname(userTO.getSurname());

            return entity.getId();
        }

        return null;
    }

    public UserTO getUserByEmail(String email){
        UserEntity user = userDAO.getUserByEmail(email);

        if(user != null){
            return userMapper.toTransferObject(user);
        }

        return null;
    }
}
