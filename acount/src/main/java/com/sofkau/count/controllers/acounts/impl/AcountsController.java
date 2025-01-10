package com.sofkau.count.controllers.acounts.impl;


import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.controllers.acounts.IAcountsController;
import com.sofkau.count.services.acounts.IAcountsServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/acounts")
public class AcountsController implements IAcountsController {


    @Autowired
    private IAcountsServices acountsServices;


    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createAcount(@Valid @RequestBody AcountEntryDTO acountEntryDTO) {
         acountsServices.createAcount(acountEntryDTO);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AcountExitDTO> getAcount(@Valid @PathVariable  Integer id ) {
        return ResponseEntity.ok(acountsServices.getAcount(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAcount(@Valid @PathVariable Integer id) {
        acountsServices.deleteAcount(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
