package ca.masonx.leek.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ca.masonx.leek.core.events.HandlerPriority;
import ca.masonx.leek.core.events.HandlerType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) /* only for functions */
public @interface LeekEventHandler {
	HandlerType handles() default HandlerType.NONE;
	HandlerPriority priority() default HandlerPriority.MEDIUM;
}