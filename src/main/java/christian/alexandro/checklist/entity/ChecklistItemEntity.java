package christian.alexandro.checklist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@Table(name = "checklist_item")
public class ChecklistItemEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("status")
    private boolean status;

    @JsonProperty("checklist_id")
    private Long checklistId;

    @JsonProperty("active_flag")
    private boolean activeFlag;
}
