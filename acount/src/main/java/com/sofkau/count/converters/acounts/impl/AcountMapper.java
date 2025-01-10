package com.sofkau.count.converters.acounts.impl;

import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.commons.users.dtos.exit.UserExitDTO;
import com.sofkau.count.converters.acounts.IAcountMapper;
import com.sofkau.count.domain.acounts.model.Acount;
import com.sofkau.count.domain.users.model.User;
import org.springframework.stereotype.Component;

@Component
public class AcountMapper implements IAcountMapper {

    @Override
    public Acount mapAcountEntryDTOtoAcount(AcountEntryDTO acountEntryDTO, User user) {
        if (acountEntryDTO == null) {
            throw new IllegalArgumentException("acount can´t be empty");
        }
        Acount acount = new Acount();
        acount.setAcountNumber(acountEntryDTO.getAcountNumber());
        acount.setBalance(acountEntryDTO.getBalance());
        acount.setType(acountEntryDTO.getType());
        acount.setUser(user);

        return acount;
    }

    @Override
    public AcountExitDTO mapAcounttoAcountExit(Acount acount) {
        if (acount == null) {
            throw new IllegalArgumentException("acount can´t be empty");
        }
        return new AcountExitDTO(
                acount.getAcountNumber(),
                acount.getBalance());
    }

}
