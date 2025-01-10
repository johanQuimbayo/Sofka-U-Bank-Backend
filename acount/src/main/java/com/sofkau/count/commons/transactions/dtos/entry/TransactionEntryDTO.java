package com.sofkau.count.commons.transactions.dtos.entry;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntryDTO implements Serializable {


    @NotNull
    private Integer acountNumber;

    @NotNull
    private Double amount;


    @NotNull
    private Integer userId;

}
