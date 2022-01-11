package pl.kk.UserControl.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSkillDTO {
    private String userEmail;
    private String SkillName;
    private String SkillLevel;
}
