package sb.techcamp.bankapi.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AccountDTO {

    private Long id;
    private Long clientId;
    private Integer typeId;
    private LocalDateTime openingDate;
    private Double balance;
    private Double compRate;
    private Double interestBalance;

    private ClientDTO client;
    private AccountTypeDTO type;

}
