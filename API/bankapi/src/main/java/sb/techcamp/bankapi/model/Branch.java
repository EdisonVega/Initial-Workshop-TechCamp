package sb.techcamp.bankapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long branchId;
    private String branchName;
    private String branchCity;
    private String branchAddress;
    private String branchOpenTime;
    private String branchCloseTime;

    @OneToMany(mappedBy = "branch")
    private List<Transaction> transactions;

}
