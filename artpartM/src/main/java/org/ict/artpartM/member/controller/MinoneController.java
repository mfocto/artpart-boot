package org.ict.artpartM.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MinoneEntity;
import org.ict.artpartM.member.model.dto.MinoneDto;
import org.ict.artpartM.member.model.service.MinoneService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MinoneController {
    private final MinoneService minoneService;

    @GetMapping("/minone/list")
    public Header<List<MinoneDto>> minoneList(
            @PageableDefault(sort = {"minidx"}) Pageable pageable,
            SearchCondition searchCondition) {
        return minoneService.getMinoneList(pageable, searchCondition);
    }

    @GetMapping("/minone/{id}")
    public MinoneDto getMinone(@PathVariable Long id) { return minoneService.getMinone(id); }

    @PostMapping("/minone")
    public MinoneEntity create(@RequestBody MinoneDto minoneDto) { return minoneService.create(minoneDto); }

    @PatchMapping("/minone")
    public MinoneEntity update(@RequestBody MinoneDto minoneDto) { return minoneService.update(minoneDto); }

    @DeleteMapping("/minone/{id}")
    public void delete(@PathVariable Long id) { minoneService.delete(id); }

}
