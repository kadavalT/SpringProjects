/**
 *
 */
package com.playground.springfeatures.controller;

import com.playground.springfeatures.service.SpringServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SpringRestAPIimpl implements SpringRestAPI {

    private final Logger logger = LoggerFactory.getLogger(SpringServiceImpl.class);

	@Autowired
	private SpringServiceImpl adminService;

	/**
	 * This Method is inherited from interface and used to
	 * validate the entered token is authenticated or not in service class.
	 *
	 * @return Response
	 */

	@Override
	public ResponseEntity<String>  getValidateToken(String token) {
		 logger.info("Strated ValidateToken method");
		 System.out.println("+++++++++++++++++++++++++++++++++++++");
		return adminService.validateToken(token);
	}

}
