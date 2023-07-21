package com.c2psi.bm.handlers;

import com.c2psi.bm.exceptions.BMException;
import com.c2psi.bm.exceptions.DuplicateEntityException;
import com.c2psi.bm.exceptions.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BMException.class)
    public ResponseEntity<?> handleException(BMException exception,
                                             WebRequest webRequest){
        log.info("A BMException is launch on the server side means it is not correspond to any specific exception " +
                "that our application can throw");
        final HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorDto errorDto =  ErrorDto.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errorList(exception.getErrors()!=null?(!exception.getErrors().isEmpty()?exception.getErrors().stream().toList():null):null)
                .build();
        Map<String, Object> map = new LinkedHashMap<>();
        map.clear();
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        map.put("message", "Some problems occurs during execution: Internal Server Error");
        map.put("data", errorDto);
        map.put("cause", "Des exceptions ont ete lance pendant l'execution de la methode. consulter le errorDto " +
                "pour plus de details");
        return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
        //return new ResponseEntity<>(errorDto, badRequest);

    }

    @ExceptionHandler(DuplicateEntityException.class)
    public ResponseEntity<ErrorDto> handleException(DuplicateEntityException exception,
                                                    WebRequest webRequest){
        log.info("A DuplicateEntityException is launch on the server side");
        final HttpStatus badRequest = HttpStatus.CONFLICT;
        final ErrorDto errorDto =  ErrorDto.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errorList(exception.getErrors()!=null?(exception.getErrors()!=null?(!exception.getErrors().isEmpty()?exception.getErrors().stream().toList():null):null):null)
                .build();
        Map<String, Object> map = new LinkedHashMap<>();
        map.clear();
        map.put("status", HttpStatus.CONFLICT);
        map.put("message", "The entity sent is already exist with the same identity in the DB: CONFLICT");
        map.put("data", errorDto);
        map.put("cause", "Une entite est deja enregistre en BD avec les memes identifiant. Consulter le ErrorDto " +
                "pour plus de details");
        return new ResponseEntity(map, HttpStatus.CONFLICT);
        //return new ResponseEntity<>(errorDto, badRequest);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception,
                                                    WebRequest webRequest){
        log.info("A InvalidEntityException is launch on the server side");
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto =  ErrorDto.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errorList(exception.getErrors()!=null?(!exception.getErrors().isEmpty()?exception.getErrors().stream().toList():null):null)
                .build();
        Map<String, Object> map = new LinkedHashMap<>();
        map.clear();
        map.put("status", HttpStatus.BAD_REQUEST);
        map.put("message", "The entity is not valid and the operation cannot be process: BAD_REQUEST");
        map.put("data", errorDto);
        map.put("cause", "L'entite n'est pas valide et l'operation ne peut etre realisee. Consulter le ErrorDto " +
                "pour plus de details");
        return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        //return new ResponseEntity<>(errorDto, badRequest);
    }
}
