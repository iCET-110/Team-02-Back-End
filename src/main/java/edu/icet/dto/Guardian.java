package edu.icet.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guardian {

    private String guardianName;
    private String guardianNIC;
    private String guardianContact;

}
