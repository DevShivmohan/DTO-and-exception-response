package com.example.dto.exception.handler;

import com.example.dto.exception.InternalServerException;
import com.example.dto.exception.SomeTechnicalProblemException;
import com.example.dto.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {


    /**
     * if user already exist then getting this error message to client
     * @param userAlreadyExistException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        log.error(userAlreadyExistException.getMessage());
        return ResponseEntity.status(HttpStatus.IM_USED).body(userAlreadyExistException.getMessage());
    }

    /**
     * when throw InternalServerException from anywhere then response by this method
     * @param internalServerException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> handleThrowServerException(InternalServerException internalServerException){
        log.error(internalServerException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(internalServerException.getMessage());
    }

    /**
     * if SomeTechnicalProblemException is arised from anywhere then give response
     * @param someTechnicalProblemException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(SomeTechnicalProblemException.class)
    public ResponseEntity<?> handleThrowSomeTechnicalProblem(SomeTechnicalProblemException someTechnicalProblemException){
        log.error(someTechnicalProblemException.getMessage());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(someTechnicalProblemException.getMessage());
    }

}
