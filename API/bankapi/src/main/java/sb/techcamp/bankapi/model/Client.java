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
    @Column(name = "client_id", nullable = false, updatable = false)
    private Long clientId;

    @Column(nullable = false, unique = true)
    private Long clientDocument;
    @Column(nullable = false)
    private String clientName;
    @Column(nullable = false)
    private String clientLastname;
    private String clientSex;
    @Column(nullable = false)
    private String clientPhone;
    @Column(nullable = false)
    private String clientAddress;
    @Column(nullable = false)
    private String clientEmail;
    @Column(nullable = false)
    private String clientPassword;
    private Boolean clientActive;

    @OneToMany(mappedBy = "client")
    private List<Account> Accounts;

}
