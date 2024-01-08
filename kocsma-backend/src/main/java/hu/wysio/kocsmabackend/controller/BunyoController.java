package hu.wysio.kocsmabackend.controller;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.bunyo.BunyoTabellaDto;
import hu.wysio.kocsmabackend.service.BunyoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bunyo")
public class BunyoController {

	@Autowired
	private BunyoService bunyoService;

	@PostMapping
	public ResponseEntity<Void> beginBunyo(@RequestParam List<Long> vendegIdList) throws KocsmaException {

		bunyoService.beginBunyo(vendegIdList);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> vendegKiesett(@RequestParam long id) throws KocsmaException {

		bunyoService.vendegKiesett(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping
	public ResponseEntity<List<BunyoTabellaDto>> getBunyoTabella() throws KocsmaException {

		return ResponseEntity.status(HttpStatus.OK).body(bunyoService.getBunyoTabella());
	}
}
