package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;

public class ItalException extends KocsmaException {
	public ItalException(ErrorMessage errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
