package com.hpperc.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandling {

	private static Logger logger=LogManager.getLogger(GlobalExceptionHandling.class);
	

	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException ex){
		ModelAndView model=new ModelAndView();
		logger.error("SQL Exception occured :", ex);
		model.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addObject("exception", "Database Error Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	} 
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleConstraintViolationException(ConstraintViolationException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Constraint Violation Exception occured :", ex);
		model.addObject("status", HttpStatus.BAD_REQUEST.value());
		model.addObject("exception", "Field Validation Problem Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingServletRequestParameterException(MethodArgumentTypeMismatchException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Request Parameter Missing Exception occured :", ex);
		model.addObject("status", HttpStatus.BAD_REQUEST.value());
		model.addObject("exception", "Request Parameter Missing Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ModelAndView handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Method Argument Type Mismatch Exception occured :", ex);
		model.addObject("status", HttpStatus.BAD_REQUEST.value());
		model.addObject("exception", "Method Argument Type Mismatch Exception occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException ex){
		ModelAndView model=new ModelAndView();
		logger.error("IO Exception occured :", ex);
		model.addObject("status", HttpStatus.NOT_FOUND.value());
		model.addObject("exception", "IO Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(AmbiguousBindingException.class)
	public ModelAndView handleAmbiguousBindingException(AmbiguousBindingException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Ambiguous Binding Exception occured :", ex);
		model.addObject("status", HttpStatus.IM_USED.value());
		model.addObject("exception", "Ambiguous Binding Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(ArithmeticException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Arithmetic Exception occured :", ex);
		model.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addObject("exception", "Arithmetic Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(ClassCastException.class)
	public ModelAndView handleClassCastException(ClassCastException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Number Format Exception occured :", ex);
		model.addObject("status", HttpStatus.FORBIDDEN.value());
		model.addObject("exception", "Class Cast Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormatException(NumberFormatException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Number Format Exception occured :", ex);
		model.addObject("status", HttpStatus.BAD_REQUEST.value());
		model.addObject("exception", "Number Format Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ModelAndView handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Null Pointer Exception occured :", ex);
		model.addObject("status", HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.value());
		model.addObject("exception", "Array Index Out Of Bounds Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(NullPointerException ex){
		ModelAndView model=new ModelAndView();
		logger.error("Null Pointer Exception occured :", ex);
		model.addObject("status", HttpStatus.NO_CONTENT.value());
		model.addObject("exception", "Null Pointer Exception Occured, Please Contact Support.");
		model.setViewName("global_exception");
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex){
		ModelAndView model=new ModelAndView();
		logger.error("Something went to wrong :", ex);
		model.addObject("exception", ex);
		model.setViewName("global_exception");
		return model;
	}
	
}
