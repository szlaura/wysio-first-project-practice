package hu.wysio.kocsmabackend.controller;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.kocsmazas.CreateKocsmazasRequestDto;
import hu.wysio.kocsmabackend.dto.kocsmazas.FinishKocsmazasRequestDto;
import hu.wysio.kocsmabackend.service.KocsmazasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kocsmazas")
public class KocsmazasController {

	@Autowired
	private KocsmazasService kocsmazasService;

	@PostMapping
	public ResponseEntity<Void> beginKocsmazas(@RequestBody CreateKocsmazasRequestDto kocsmazasDto) throws KocsmaException {

		kocsmazasService.beginKocsmazas(kocsmazasDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PutMapping("{id}")
	public ResponseEntity<Void> finishKocsmazas(@PathVariable("id") Long id, @Validated @RequestBody FinishKocsmazasRequestDto kocsmazasDto) throws
			KocsmaException {

		kocsmazasService.finishKocsmazas(id, kocsmazasDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}

