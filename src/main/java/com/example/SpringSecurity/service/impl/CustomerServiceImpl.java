package com.example.SpringSecurity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private SessionRegistry sessionRegistry;

	@Override
	public Map<String, Object> getSessionData() {
        String sessionId = "";
        User userDetail = null;

        List<Object> sessions = sessionRegistry.getAllPrincipals();
        for (Object session : sessions) {
            if (session instanceof User) {
                userDetail = (User) session;
            }

            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
            for (SessionInformation sessionInformation :sessionInformations) {
                sessionId = sessionInformation.getSessionId();
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("response", "Hello World!");
        response.put("sessionId", sessionId);
        response.put("sessionUser", userDetail);
		
        return response;
	}

}
