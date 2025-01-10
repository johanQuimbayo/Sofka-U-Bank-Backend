package com.sofkau.count.data.acounts.repository;



import com.sofkau.count.data.acounts.model.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcountsRepository extends JpaRepository<Acount, Integer> {

    Optional<Acount> findById(Integer id);

    Optional<Acount> findByAcountNumber(Integer accountNumber);


}
