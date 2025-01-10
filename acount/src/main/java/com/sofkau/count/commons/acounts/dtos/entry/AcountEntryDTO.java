package com.sofkau.count.commons.acounts.dtos.entry;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcountEntryDTO implements Serializable {


    @NotNull
    private Integer acountNumber;

    @NotNull
    private Double balance;

    @NotNull
    private String type;

    @NotNull
    private Integer userId;

}
