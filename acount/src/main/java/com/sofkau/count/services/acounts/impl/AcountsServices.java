package com.sofkau.count.services.acounts.impl;


import com.sofkau.count.commons.acounts.dtos.entry.AcountEntryDTO;
import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.exceptions.AlreadyExistsException;
import com.sofkau.count.exceptions.NotFoundException;
import com.sofkau.count.converters.acounts.IAcountMapper;
import com.sofkau.count.domain.acounts.model.Acount;
import com.sofkau.count.domain.acounts.repository.AcountsRepository;
import com.sofkau.count.domain.users.model.User;
import com.sofkau.count.domain.users.repository.UsersRepository;
import com.sofkau.count.services.acounts.IAcountsServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcountsServices implements IAcountsServices {

    @Autowired
    AcountsRepository acountsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    IAcountMapper iAcountMapper;


    @Override
    @Transactional
    public void createAcount(AcountEntryDTO acountEntryDTO) {

        acountsRepository.findByAcountNumber(acountEntryDTO.getAcountNumber()).ifPresent(
                u -> {
                    throw new AlreadyExistsException("already exist an acount with the same number");
                });

        User user = usersRepository.findById(acountEntryDTO.getUserId()).orElseThrow(
                () -> new NotFoundException("User not Found")
        );

        Acount acount = iAcountMapper.mapAcountEntryDTOtoAcount(acountEntryDTO, user);
        acountsRepository.save(acount);

    }


    @Override
    public AcountExitDTO getAcount(Integer id) {
        Acount acount = acountsRepository.findById(
                id).orElseThrow(() -> new NotFoundException("Acount not Found"));
        return iAcountMapper.mapAcounttoAcountExit(acount);
    }

    @Override
    @Transactional
    public void deleteAcount(Integer id) {
        Acount acount = acountsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Can´t delete acount if this doesn´t exist")
        );
        acountsRepository.delete(acount);
    }
}
