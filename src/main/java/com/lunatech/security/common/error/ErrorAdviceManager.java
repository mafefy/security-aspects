package com.lunatech.security.common.error;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import com.lunatech.security.common.model.Response;
import com.lunatech.security.blocking.BlockingOperationService;



@ControllerAdvice
@RestController
@Order(Ordered.LOWEST_PRECEDENCE)
public class ErrorAdviceManager {

	@Autowired
	private BlockingOperationService blockingService;

	@ExceptionHandler
	public Response processAppError(AppError appError) {
		return handleError(appError, false);
	}



	@ExceptionHandler
	public Response processDataError(DataAccessException exception) {
		exception.printStackTrace();
		return handleError(new ValidationError("Data access exception"), true);
	}

	@ExceptionHandler
	public Response processNotExistElement(NoSuchElementException exception) {
		exception.printStackTrace();
		return handleError(new NotAllowedError("No such element exist"), false);
	}

	

	@ExceptionHandler
	public Response generalException(RuntimeException general) {
		// log the exception trace
		general.printStackTrace();
		return handleError(new FailureError("System issue kindly check with system administrators"), true);
	}

	private Response handleError(AppError error, boolean log) {
		// check if has violation
		if (error.getViolation() != null) {
			blockingService.addViolation(error.getViolation());
		}

		if (log) {
			error.printStackTrace();
		}

		return new Response(false, error.clearStackTrace());
	}

}
