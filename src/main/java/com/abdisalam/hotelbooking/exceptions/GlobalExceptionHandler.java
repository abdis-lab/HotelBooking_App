//package com.abdisalam.hotelbooking.exceptions;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.resource.NoResourceFoundException;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(NoResourceFoundException.class)
//    public ModelAndView handleNoResourceFoundException(NoResourceFoundException ex) {
//        logger.error("Resource not found:", ex);
//
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("message", "The requested resource was not found.");
//        return modelAndView;
//    }
//}