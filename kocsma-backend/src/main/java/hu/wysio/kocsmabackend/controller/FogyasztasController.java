package hu.wysio.kocsmabackend.controller;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.fogyasztas.CreateFogyasztasRequestDto;
import hu.wysio.kocsmabackend.dto.fogyasztas.VendegElfogyasztottAlkoholMennyisegDto;
import hu.wysio.kocsmabackend.service.FogyasztasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fogyasztas")
public class FogyasztasController {

	@Autowired
	private FogyasztasService fogyasztasService;

	@GetMapping
	public ResponseEntity<List<VendegElfogyasztottAlkoholMennyisegDto>> getVendegRangsorByElfogyasztottAlkoholMennyiseg() throws KocsmaException {

		return ResponseEntity.status(HttpStatus.OK).body(fogyasztasService.getVendegRangsorByElfogyasztottAlkoholMennyiseg());
	}

	@PostMapping
	public ResponseEntity<Void> createFogyasztas(@Validated @RequestBody CreateFogyasztasRequestDto fogyasztasDto) throws KocsmaException {

		fogyasztasService.createFogyasztas(fogyasztasDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
