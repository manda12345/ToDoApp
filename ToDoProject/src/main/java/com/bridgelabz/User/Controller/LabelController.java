package com.bridgelabz.User.Controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.User.Service.UserService;
import com.bridgelabz.User.Utility.Token;
import com.bridgelabz.User.model.CustomeResponse;
import com.bridgelabz.User.model.User;

@RestController
public class LabelController {
	
	@Autowired
	private UserService UserService;
	CustomeResponse myResponse = new CustomeResponse();
	
	@RequestMapping(value = "savelabel", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> saveLabel(RequestBody NoteLabel,HttpServletRequest request)
	{
		String token = request.getHeader("token");
		int id = Token.verify(token);
		User userId=UserService.getUserById(id);
		
		if(userId != null)
		{
			
		}

		return null;
		
	}
	

}
