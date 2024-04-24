package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistEntity;
import christian.alexandro.checklist.entity.ChecklistItemEntity;
import christian.alexandro.checklist.repository.ChecklistItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistItemService {
    private final ChecklistItemRepository checklistItemRepository;

    public ResponseEntity<List<ChecklistItemEntity>> detailChecklistItem(Long checklistId) {
        List<ChecklistItemEntity> allChecklistItem = checklistItemRepository.findAllByChecklistIdAndActiveFlagTrue(checklistId);
        return new ResponseEntity<>(allChecklistItem, HttpStatus.OK);
    }

    public ResponseEntity<ChecklistItemEntity> getChecklistItem(Long checklistId, Long checklistItemId) {
        ChecklistItemEntity response = checklistItemRepository.findByChecklistIdAndIdAndActiveFlagTrue(checklistId, checklistItemId).orElse(null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
