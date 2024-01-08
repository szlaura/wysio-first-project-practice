package hu.wysio.datamanager.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	CREATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Hiba létrehozás közben!"),
	UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Hiba updatelés közben!"),
	REQUEST_FAILED(HttpStatus.BAD_REQUEST, "A kérés meghiúsult!"),
	GET_DATA_FAILED(HttpStatus.NOT_FOUND, "Hiba a lekérdezés közben!"),
	NO_DATA(HttpStatus.NOT_FOUND, "Nincs ilyen adat!");

	private final HttpStatus httpStatus;
	private final String message;
}
