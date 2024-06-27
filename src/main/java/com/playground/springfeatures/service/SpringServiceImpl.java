package com.playground.springfeatures.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.springfeatures.dto.TokenResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.playground.springfeatures.util.RestClientUtil;

@Service
public class SpringServiceImpl {

    private static final String URL = "https://mp1b4ca47e7c2f31c24c.free.beeceptor.com/data";
    private final Logger logger = LoggerFactory.getLogger(SpringServiceImpl.class);
    private final RestClientUtil restClientUtil;

    @Autowired
    public SpringServiceImpl(RestClientUtil restClientUtil) {
        this.restClientUtil = restClientUtil;
    }

    public ResponseEntity<String> validateToken(String token) {
    	 logger.info("Strated ValidateToken method");
        if (StringUtils.isBlank(token)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No token provided");
        }
        try {
            String response = restClientUtil.get(URL);
            TokenResponseDTO tokenResponseDTO = new ObjectMapper().readValue(response, TokenResponseDTO.class);
            logger.info(tokenResponseDTO.toString());
            if(token.equals(tokenResponseDTO.getToken())){
                return ResponseEntity.status(HttpStatus.OK).body("Token is Authenticated");
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is unauthorized");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while calling external API");
        }
    }
}
