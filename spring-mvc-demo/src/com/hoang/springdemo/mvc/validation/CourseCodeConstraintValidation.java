package com.hoang.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidation implements ConstraintValidator<CourseCode, String> {

	//private String coursePrefix;
	
	// cach check nhieu option hon	
	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefixes = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result = false;
		
		 if(theCode != null) {
			 //result = theCode.startsWith(coursePrefix);
			 
			 //
	            // loop thru course prefixes
	            //
	            // check to see if code matches any of the course prefixes
	            //
	            for (String tempPrefix : coursePrefixes) {
	                result = theCode.startsWith(tempPrefix);
	                
	                // if we found a match then break out of the loop
	                if (result) {
	                    break;
	                }
	            }
		 }
		 else {
			 result = true;
		 }
		
		return result;
	}

}
