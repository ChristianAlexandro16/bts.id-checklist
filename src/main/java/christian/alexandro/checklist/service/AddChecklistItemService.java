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
public class AddChecklistItemService {
    private final ChecklistItemRepository checklistItemRepository;

    public ResponseEntity<String> addChecklistItem(String name, Long checklistId) {
        String check = checkEmptyNotNull(name);

        if (check != null) {
            return new ResponseEntity<>(check, HttpStatus.BAD_REQUEST);
        }

        boolean isNameExist = checklistItemRepository.findByNameAndChecklistIdAndActiveFlagTrue(name, checklistId).isPresent();

        if (isNameExist) {
            return new ResponseEntity<>("Nama sudah didaftarkan", HttpStatus.CONFLICT);
        }

        ChecklistItemEntity newData = new ChecklistItemEntity();
        newData.setItemName(name);
        newData.setChecklistId(checklistId);
        newData.setActiveFlag(true);
        newData.setStatus(false);

        ChecklistItemEntity response = checklistItemRepository.save(newData);

        if (response != null) {
            return new ResponseEntity<>("Registrasi berhasil", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
