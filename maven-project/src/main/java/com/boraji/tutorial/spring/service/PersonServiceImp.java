package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.DAO.PersonDao;
import com.boraji.tutorial.spring.entity.Person;

/**
 * @author imssbora
 *
 */
@Service
public class PersonServiceImp implements PersonService {

   @Autowired
   private PersonDao userDao;

   @Transactional
   public void add(Person person) {
      userDao.add(person);
   }

   @Transactional(readOnly = true)
   public List<Person> listPersons() {
      return userDao.listPersons();
   }

}