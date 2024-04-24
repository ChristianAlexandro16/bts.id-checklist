package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistItemEntity;
import christian.alexandro.checklist.repository.ChecklistItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteChecklistItemService {
    private final ChecklistItemRepository checklistItemRepository;

    public ResponseEntity<String> removeChecklistItem(Long checklistId, Long checklistItemId) {
        ChecklistItemEntity response = checklistItemRepository.findByChecklistIdAndIdAndActiveFlagTrue(checklistId, checklistItemId).orElse(null);

        if (response == null) {
            return new ResponseEntity<>("Data not found", HttpStatus.BAD_REQUEST);
        } else {
            response.setActiveFlag(false);
            checklistItemRepository.save(response);
        }
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
