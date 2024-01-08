package hu.wysio.datamanager.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

	//TODO dátumokat kiszervezni
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
	private LocalDateTime timestamp;
	private String httpStatus;
	private String message;

}
