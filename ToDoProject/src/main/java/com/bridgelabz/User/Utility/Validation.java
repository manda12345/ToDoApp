package com.bridgelabz.User.Utility;

import com.bridgelabz.User.model.User;

public class Validation {
	
	private  final  String emailValidation="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
	private  final String mobileValidation="^((\\+)?(\\d{2}[-]))?(\\d{10}){1}?$";
	private final String password="^([a-zA-Z0-9@*#]{8,15})$";

	public boolean isvalidation(User user) {

		String phoneNumber=user.getMobileNumber();
		String mobileNumber=String.valueOf(phoneNumber);
		boolean isError=false;

		if(!user.getEmail().matches(emailValidation)) {

			isError=true;

		} else if(!mobileNumber.matches(mobileValidation)) {

			isError=true;
		} else if(!user.getPassword().matches(password)) {
			isError=true;
		}

		if(isError==true) {

			return false;

		} else {

			return true;

		}
	}
}
