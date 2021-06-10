package br.com.systemsgs.keymanagerpix.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.systemsgs.keymanagerpix.exception.GenericUniqueColumnValidator;

@Documented
@Constraint(validatedBy = {GenericUniqueColumnValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenericUniqueColumn {

	String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
	
}
