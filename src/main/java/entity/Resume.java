package entity;

import dto.ResumeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resume")
public class Resume {
    @Id
    private Long id;
    private String name;
    private byte[] resume;

    public ResumeDTO toDTO(){
        return new ResumeDTO(this.id,this.name,this.resume!=null? Base64.getEncoder().encodeToString(this.resume):null);
    }
}

