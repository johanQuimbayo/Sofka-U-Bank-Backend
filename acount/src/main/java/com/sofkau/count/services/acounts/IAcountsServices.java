package com.sofkau.count.services.acounts;


import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;


public interface IAcountsServices {


    public void createAcount(AcountEntryDTO acountEntryDTO);

    public AcountExitDTO getAcount(Integer id);

    public void deleteAcount(Integer id);

}
