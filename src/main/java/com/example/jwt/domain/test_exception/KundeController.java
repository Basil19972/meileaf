package com.example.jwt.domain.test_exception;

import com.example.jwt.domain.test_exception.dto.KundeDTO;
import com.example.jwt.domain.test_exception.dto.KundeMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/kunde")
public class KundeController {

    private KundeService kundeService;
    private KundeMapper kundeMapper;

    public KundeController(KundeService kundeService, KundeMapper kundeMapper) {
        this.kundeService = kundeService;
        this.kundeMapper = kundeMapper;
    }

    @PostMapping()
    public ResponseEntity<KundeDTO> create(@Validated @RequestBody KundeDTO kundeDTO) {
        return new ResponseEntity<>(kundeMapper.toDTO(kundeService.save(kundeMapper.fromDTO(kundeDTO))), HttpStatus.CREATED);
    }




}
