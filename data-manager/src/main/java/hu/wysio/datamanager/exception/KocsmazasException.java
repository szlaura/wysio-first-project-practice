package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;

public class KocsmazasException extends KocsmaException {

	public KocsmazasException(ErrorMessage errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
