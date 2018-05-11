package com.ssh.service.impl;

import com.ssh.entity.Person;
import com.ssh.repository.PersonRepository;
import com.ssh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by XRog
 * On 2/2/2017.2:40 PM
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

//    @Transactional
//   @Transactional(rollbackFor=Exception.class)
    public Long savePerson() {
//        Person person = new Person();
        String insert="_23";
//        person.setUsername("XRog"+insert);
//        person.setPhone("18381005946"+insert);
//        person.setAddress("chenDu"+insert);
//        person.setRemark("this is XRog"+insert);
//        Long save = personRepository.save(person);
//        if(save!=-1) {
//        	throw new RuntimeException();
//        }
        Person person1 = new Person();
        insert="_14";
        person1.setUsername("XRog"+insert);
        person1.setPhone("18381005946"+insert);
        person1.setAddress("chenDu"+insert);
        person1.setRemark("this is XRog"+insert);
        return personRepository.save(person1);
    }
}