package hu.wysio.kocsmabackend.controller;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.vendeg.VendegDto;
import hu.wysio.kocsmabackend.service.VendegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendeg")
public class VendegController {

	@Autowired
	private VendegService vendegService;

	@PostMapping
	public ResponseEntity<Void> createVendeg(@Validated @RequestBody VendegDto vendegDto) throws KocsmaException {

		vendegService.createVendeg(vendegDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}

