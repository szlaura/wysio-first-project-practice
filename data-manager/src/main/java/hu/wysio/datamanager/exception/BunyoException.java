package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;

public class BunyoException extends KocsmaException {
	public BunyoException(ErrorMessage errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
