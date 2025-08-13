package dto;

import entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String name;
    private String email;
    private String overview;
    private String industry;
    private String website;
    private int size;
    private String headQuarters;
    private List<String> specialties;

    public Company toEntity(){
        return new Company(this.id,this.name,this.email,this.overview,this.industry,this.website,this.size,this.headQuarters,this.specialties);
    }
}

