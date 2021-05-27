package sb.techcamp.bankapi.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private Long id;
    private Long document;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Boolean active;

    // if firstName is not null then concat first and last names else return ""
    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }

}
