package hu.wysio.datamanager.exception;

import hu.wysio.datamanager.message.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KocsmaException extends Exception {

	final ErrorMessage errorMessage;

	public KocsmaException(ErrorMessage errorMessage, Throwable cause) {
		super(errorMessage.getMessage(), cause);
		this.errorMessage = errorMessage;
	}
}
