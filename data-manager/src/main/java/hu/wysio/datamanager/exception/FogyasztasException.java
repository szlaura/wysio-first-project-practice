package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;

public class FogyasztasException extends KocsmaException {
	public FogyasztasException(ErrorMessage errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
