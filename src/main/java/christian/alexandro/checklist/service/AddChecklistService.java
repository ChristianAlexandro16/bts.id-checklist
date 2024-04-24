package christian.alexandro.checklist.service;

import christian.alexandro.checklist.entity.ChecklistEntity;
import christian.alexandro.checklist.repository.ChecklistRepository;
import christian.alexandro.checklist.util.CheckNameUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static christian.alexandro.checklist.util.CheckNameUtil.checkEmptyNotNull;

@Service
@RequiredArgsConstructor
public class AddChecklistService {
    private final ChecklistRepository checklistRepository;

    public ResponseEntity<String> addChecklist(String name) {
        String check = checkEmptyNotNull(name);

        if (check != null) {
            return new ResponseEntity<>(check, HttpStatus.BAD_REQUEST);
        }

        boolean isNameExist = checklistRepository.findByNameAndActiveFlagTrue(name).isPresent();

        if (isNameExist) {
            return new ResponseEntity<>("Nama sudah didaftarkan", HttpStatus.CONFLICT);
        }

        ChecklistEntity newData = new ChecklistEntity();
        newData.setName(name);
        newData.setActiveFlag(true);

        ChecklistEntity response = checklistRepository.save(newData);

        if (response != null) {
            return new ResponseEntity<>("Registrasi berhasil", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
