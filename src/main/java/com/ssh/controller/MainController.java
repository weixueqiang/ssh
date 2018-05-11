package com.ssh.controller;

import com.ssh.entity.Person;
import com.ssh.service.PersonService;
import com.ssh.service.TestService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public List<String> savePerson(){
        personService.savePerson();
        List<String> list=new ArrayList<>();
        list.add("success!中文测试");
        list.add("success!中文测试2");
        
        return list;
    }
    
    @RequestMapping("/test")
    public String test(HttpServletRequest req) {
    	System.out.println("test----------\n");
    	req.setAttribute("chn", "测试");
    	return "test";
    }
    
}