package sb.techcamp.bankapi.dto;

import lombok.Data;

@Data
public class BranchDTO {

    private Long id;
    private String name;
    private String city;
    private String address;
    private String openTime;
    private String closeTime;

    public String getSchedule() {
        return (openTime != null && closeTime != null)
                ? openTime.concat(" - ").concat(closeTime) : "";
    }

}
