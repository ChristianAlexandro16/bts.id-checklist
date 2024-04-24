package christian.alexandro.checklist.controller;

import christian.alexandro.checklist.dto.ChecklistRequest;
import christian.alexandro.checklist.entity.ChecklistItemEntity;
import christian.alexandro.checklist.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
public class ChecklistItemController {
    private final AddChecklistItemService addChecklistItemService;
    private final ChecklistItemService checklistItemService;
    private final UpdateChecklistItemService updateChecklistItemService;
    private final DeleteChecklistItemService deleteChecklistItemService;
    private final UpdateChecklilstItemNameService updateChecklilstItemNameService;

    @PostMapping("/checklist/{checklistId}/item")
    public ResponseEntity<String> newChecklistItem(@RequestBody ChecklistRequest checklist,
                                                   @PathVariable Long checklistId){
        return addChecklistItemService.addChecklistItem(checklist.getName(), checklistId);
    }

    @GetMapping("/checklist/{checklistId}/item")
    public ResponseEntity<List<ChecklistItemEntity>> detailChecklist(@PathVariable Long checklistId){
        return checklistItemService.detailChecklistItem(checklistId);
    }

    @GetMapping("/checklist/{checklistId}/item/{checklistItemId}")
    public ResponseEntity<ChecklistItemEntity> getChecklistItem(@PathVariable Long checklistId,
                                                                @PathVariable Long checklistItemId){
        return checklistItemService.getChecklistItem(checklistId, checklistItemId);
    }

    @PutMapping("/checklist/{checklistId}/item/{checklistItemId}/")
    public ResponseEntity<String> updateItem(@PathVariable Long checklistId,
                                             @PathVariable Long checklistItemId){
        return updateChecklistItemService.updateChecklistItem(checklistId, checklistItemId);
    }

    @DeleteMapping("/checklist/{checklistId}/item/{checklistItemId}/")
    public ResponseEntity<String> deleteItem(@PathVariable Long checklistId,
                                             @PathVariable Long checklistItemId){
        return deleteChecklistItemService.removeChecklistItem(checklistId, checklistItemId);
    }

    @PutMapping("/checklist/{checklistId}/item/rename/{checklistItemId}/")
    public ResponseEntity<String> renameItem(@PathVariable Long checklistId,
                                             @PathVariable Long checklistItemId,
                                             @RequestBody ChecklistRequest checklist){
        return updateChecklilstItemNameService.renameChecklistItem(checklistId, checklistItemId, checklist.getName());
    }

}
