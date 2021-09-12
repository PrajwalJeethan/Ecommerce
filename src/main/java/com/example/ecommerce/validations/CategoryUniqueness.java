/**
 * 
 */
package com.example.ecommerce.validations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
/**
 * @author pmonthei
 *
 */
import javax.validation.Payload;

import com.example.ecommerce.model.Category;
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy=CategoryValidator.class)
public @interface CategoryUniqueness{
	String message() default "Category already exists in system.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
