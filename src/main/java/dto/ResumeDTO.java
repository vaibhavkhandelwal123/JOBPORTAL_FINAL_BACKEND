package dto;

import entity.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {
    private Long id;
    private String resume;
    public Resume toEntity(){
        return new Resume(this.id,this.resume!=null? Base64.getDecoder().decode(this.resume):null);
    }
}