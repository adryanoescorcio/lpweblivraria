package livraria.ifma.edu.livrariaweb.controller.exception;

import livraria.ifma.edu.livrariaweb.controller.io.Erro;
import livraria.ifma.edu.livrariaweb.controller.io.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ApiLivrariaExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        final Response<Erro> resp = new Response<>();
        final String mensagem = messageSource.getMessage("propriedade.invalida", null, new Locale("pt", "BR"));

        resp.add(new Erro(mensagem, ex.getLocalizedMessage()) );

        return super.handleExceptionInternal(ex, resp, headers, HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        final Response<Erro> resp = new Response<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError ->
                resp.add(
                        new Erro(fieldError.getDefaultMessage(),
                                 ex.getLocalizedMessage() )) );


        return super.handleExceptionInternal(ex, resp, headers, HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public Response<Erro> handleEmptyResultDataAccess(EmptyResultDataAccessException ex) {

        Response<Erro> Response = new Response<>();

        String mensagem = String.format("Recurso nao encontrado, esperado %d, encontrado %d ",
                                         ex.getExpectedSize(), ex.getActualSize());

        Response.add(new Erro(mensagem, ex.getMostSpecificCause().toString() ));

        return Response;


    }
}
