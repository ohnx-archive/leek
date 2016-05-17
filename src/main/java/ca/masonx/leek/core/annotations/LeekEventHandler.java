package ca.masonx.leek.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event Handler annotation.
 * Tells the game engine that a class is an event handler.
 * 
 * Sample usage: @LeekEventHandler
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) /* only for classes */
public @interface LeekEventHandler {}