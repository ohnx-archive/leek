package ca.masonx.leek.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ca.masonx.leek.core.events.HandlerPriority;
import ca.masonx.leek.core.events.HandlerType;

/**
 * Event Handler annotation.
 * Sample usage: @LeekEventHandler.
 * 
 * Handler type what kind of event the method handles.
 * Priority is used to decide which handler gets called first.
 * Higher priority = called first, lower priority = called after.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) /* only for methods */
public @interface LeekEventHandler {
	//HandlerType handles() default HandlerType.NONE;
	HandlerPriority priority() default HandlerPriority.MEDIUM;
}