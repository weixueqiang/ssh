package com.ssh.service.impl;

import com.ssh.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by XRog
 * On 2/1/2017.12:58 AM
 */
@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Override
    public String test() {
        return "test";
    }
}