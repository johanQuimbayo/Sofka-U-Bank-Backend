package com.sofkau.count.converters.acounts;


import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.domain.acounts.model.Acount;
import com.sofkau.count.domain.users.model.User;

public interface IAcountMapper {

    public Acount mapAcountEntryDTOtoAcount(AcountEntryDTO acountEntryDTO, User user);

    public AcountExitDTO mapAcounttoAcountExit(Acount acount);
}
