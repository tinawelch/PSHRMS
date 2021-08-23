package com.footlocker.common.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  public static final String DEFAULT_ERROR_VIEW = "errorPages/genericError";

  @ExceptionHandler(Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    // If the exception is annotated with @ResponseStatus rethrow it and let
    // the framework handle it
    if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
      throw e;

    ModelAndView mav = getErrorView(DEFAULT_ERROR_VIEW, HttpStatus.INTERNAL_SERVER_ERROR, req, e);
	return mav;
  }
  
  @ExceptionHandler(IllegalArgumentException.class)
  public ModelAndView illegalArgumentErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    ModelAndView mav = getErrorView(DEFAULT_ERROR_VIEW, HttpStatus.BAD_REQUEST, req, e);
	return mav;
  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ModelAndView resourceNotFoundErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    ModelAndView mav = getErrorView(DEFAULT_ERROR_VIEW, HttpStatus.NOT_FOUND, req, e);
	return mav;
  }
  
  private ModelAndView getErrorView(String viewName, HttpStatus status, HttpServletRequest req, Exception e) {
	  ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("errorCode", status.value());
		mav.addObject("errorMessage", status.getReasonPhrase());
		mav.addObject("url", req.getRequestURL());
		mav.addObject("exception", e.toString());
		mav.addObject("stacktrace", e.getStackTrace());
		
		return mav;
  }
}