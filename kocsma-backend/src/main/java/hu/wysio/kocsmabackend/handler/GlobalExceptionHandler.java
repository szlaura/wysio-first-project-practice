package hu.wysio.kocsmabackend.handler;

import hu.wysio.datamanager.exception.ErrorResponse;
import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.message.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(KocsmaException.class)
	public final ResponseEntity<ErrorResponse> handleKocsmaException(KocsmaException ex) {

		ErrorMessage errorMessage = ex.getErrorMessage();
		HttpStatus httpStatus = errorMessage.getHttpStatus();
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), httpStatus.toString(), errorMessage.getMessage());

		log.error(error.getMessage(), ex);

		return ResponseEntity.status(httpStatus).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
																  WebRequest request) {

		Map<String, Set<String>> errorMessages =
				ex.getBindingResult().getFieldErrors()
						.stream()
						.collect(Collectors.groupingBy(FieldError::getField,
								Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())));

		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), status.toString(), errorMessages.toString());

		log.error(error.getMessage(), ex);

		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), status.toString(), ex.getMessage());

		log.error(error.getMessage(), ex);

		return ResponseEntity.status(status).body(error);
	}
}
