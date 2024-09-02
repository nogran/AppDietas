package com.nogran.app.dietas.api.domain.handle;

import com.nogran.app.dietas.api.domain.exception.BadRequestException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = {ExpiredJwtException.class})
  public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex,
      WebRequest request) {
    var errMsg = "error Token provided is expired";
    return new ResponseEntity<Object>(errMsg, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(value = {BadRequestException.class})
  public ResponseEntity<Object> handleBadRequestException(BadRequestException ex,
      WebRequest request) {
    var errMsg = ex.getMessage();
    return new ResponseEntity<Object>(errMsg, HttpStatus.BAD_REQUEST);
  }
}
