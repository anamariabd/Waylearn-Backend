package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class DocumentUploadExceptionAdvice {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<?> HandledMaxSizeException(MaxUploadSizeExceededException exception){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Verificar el tamaño de los archivos");
	}
}
