package com.sofkau.count.controllers.acounts;



import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import org.springframework.http.ResponseEntity;

public interface IAcountsController {

    public ResponseEntity<Void> createAcount(AcountEntryDTO acountEntryDTO);

    public ResponseEntity<AcountExitDTO> getAcount(Integer id);

    public ResponseEntity<Void> deleteAcount(Integer id);

}
