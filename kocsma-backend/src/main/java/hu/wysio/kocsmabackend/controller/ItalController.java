package hu.wysio.kocsmabackend.controller;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.ital.ItalDto;
import hu.wysio.kocsmabackend.service.ItalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ital")
public class ItalController {

	@Autowired
	private ItalService italService;

	@PostMapping
	public ResponseEntity<Void> createItal(@Validated @RequestBody ItalDto italDto) throws KocsmaException {

		italService.createItal(italDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
