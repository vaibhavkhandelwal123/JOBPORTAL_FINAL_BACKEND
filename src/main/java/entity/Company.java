package entity;

import dto.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "company")
public class Company {
    @Id
    private Long id;
    private String name;
    private String email;
    private byte[] pictures;
    private String overview;
    private String industry;
    private String website;
    private int size;
    private String headQuarters;
    private List<String> specialties;


    public CompanyDTO toDTO(){
        return new CompanyDTO(this.id,this.name,this.email,this.pictures!=null? Base64.getEncoder().encodeToString(this.pictures):null,this.overview,this.industry,this.website,this.size,this.headQuarters,this.specialties);
    }

}
