package com.sofkau.count.commons.acounts.dtos.exit;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcountExitDTO implements Serializable {

    private Integer acountNumber;

    private Double balance;

}
