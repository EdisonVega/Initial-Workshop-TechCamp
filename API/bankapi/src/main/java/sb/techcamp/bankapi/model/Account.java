package sb.techcamp.bankapi.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long accountId;
    private Long accountClientId;
    @Column(nullable = false, updatable = false)
    private Integer accountTypeId;
    @Column(updatable = false)
    private LocalDateTime accountOpeningDate;
    private Double accountBalance;
    private Double accountCompRate;  // Taza de capitalizacion de la cuenta, puede ser 0
    private Double accountInterestBalance; // Intereses generados por la capitalizacion del saldo de forma diaria

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client cliente;
}
