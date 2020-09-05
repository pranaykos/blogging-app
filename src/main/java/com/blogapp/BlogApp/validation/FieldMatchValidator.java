package com.blogapp.BlogApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<MatchField, Object> {

	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	@Override
	public void initialize(MatchField matchField) {
		this.firstFieldName = matchField.firstFieldName();
		this.secondFieldName = matchField.secondFieldName();
		this.message = matchField.message();
	}
	
	@Override
	public boolean isValid(Object user, ConstraintValidatorContext context) {
		boolean isValid = false;
		
		try {
			final Object firstFeildValue = new BeanWrapperImpl(user).getPropertyValue(firstFieldName);
			final Object secondFeildValue = new BeanWrapperImpl(user).getPropertyValue(secondFieldName);
			
			isValid = ( firstFeildValue == null && secondFeildValue == null ) 
									||
						(firstFeildValue != null && secondFeildValue.equals(firstFeildValue));
		}catch (Exception e) {
			// Do nothing
		}
		
		
		if(!isValid) {
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName)
			.addConstraintViolation().disableDefaultConstraintViolation();
		}
		
		return isValid;
		
	}

}
