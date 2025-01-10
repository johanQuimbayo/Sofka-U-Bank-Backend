package com.sofkau.count.commons.transactions.dtos.exit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionExitDTO implements Serializable {

    private String acountNumber;

    private String balance;

}
