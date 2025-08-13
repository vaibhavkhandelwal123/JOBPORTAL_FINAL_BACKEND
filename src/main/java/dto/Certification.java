package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    private String title;
    private String issuer;
    private LocalDateTime issueDate;
    private String certificateId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class companyDTO {
        private Long id;
        private String name;
        private String overview;
        private String industry;
        private String website;
        private int size;
        private String headQuarters;
        private List<String> specialties;
    }
}
