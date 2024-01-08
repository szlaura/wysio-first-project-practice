package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;

public class VendegException extends KocsmaException {
	public VendegException(ErrorMessage errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
