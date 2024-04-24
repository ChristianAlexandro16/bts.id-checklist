package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistItemEntity;
import christian.alexandro.checklist.repository.ChecklistItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static christian.alexandro.checklist.util.CheckNameUtil.checkEmptyNotNull;

@Service
@RequiredArgsConstructor
public class UpdateChecklilstItemNameService {
    private final ChecklistItemRepository checklistItemRepository;

    public ResponseEntity<String> renameChecklistItem(Long checklistId, Long checklistItemId, String name) {
        String check = checkEmptyNotNull(name);

        if (check != null) {
            return new ResponseEntity<>(check, HttpStatus.BAD_REQUEST);
        }

        ChecklistItemEntity checkItem = checklistItemRepository.findByChecklistIdAndItemNameAndActiveFlagTrue(checklistId, name).orElse(null);

        if (checkItem != null){
            return new ResponseEntity<>("Name has been used", HttpStatus.BAD_REQUEST);
        }

        ChecklistItemEntity response = checklistItemRepository.findByChecklistIdAndIdAndActiveFlagTrue(checklistId, checklistItemId).orElse(null);

        if (response != null) {
            response.setItemName(name);
            checklistItemRepository.save(response);
        }

        return new ResponseEntity<>("Rename success", HttpStatus.BAD_REQUEST);
    }
}
