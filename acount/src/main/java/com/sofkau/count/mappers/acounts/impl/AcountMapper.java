package com.sofkau.count.mappers.acounts.impl;

import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.mappers.acounts.IAcountMapper;
import com.sofkau.count.data.acounts.model.Acount;
import com.sofkau.count.data.users.model.User;
import org.springframework.stereotype.Component;

@Component
public class AcountMapper implements IAcountMapper {

    @Override
    public Acount mapAcountEntryDTOtoAcount(AcountEntryDTO acountEntryDTO, User user) {
        if (acountEntryDTO == null) {
            throw new IllegalArgumentException("acount can´t be empty");
        }
        return Acount.builder()
                .acountNumber(acountEntryDTO.getAcountNumber())
                .balance(acountEntryDTO.getBalance())
                .type(acountEntryDTO.getType())
                .user(user).build();

    }

    @Override
    public AcountExitDTO mapAcounttoAcountExit(Acount acount) {
        if (acount == null) {
            throw new IllegalArgumentException("acount can´t be empty");
        }
        return AcountExitDTO.builder()
                .acountNumber(acount.getAcountNumber())
                .balance(acount.getBalance())
                .build();
    }

}
