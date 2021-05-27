package sb.techcamp.bankapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long clientId;
    private Long clientDocument;
    private String clientName;
    private String clientLastname;
    private String clientSex;
    private String clientPhone;
    private String clientAddress;
    private String clientEmail;
    private String clientPassword;
    private Boolean clientActive;

    @OneToMany(mappedBy = "client")
    private List<Account> clientAccounts;

}
