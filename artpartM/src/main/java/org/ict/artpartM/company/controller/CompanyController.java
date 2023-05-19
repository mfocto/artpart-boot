package org.ict.artpartM.company.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.company.entity.CompanyEntity;
import org.ict.artpartM.company.model.dto.CompanyDto;
import org.ict.artpartM.company.model.service.CompanyService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping("/company/list")
    public Header<List<CompanyDto>> companyList(
            @PageableDefault(sort = {"companyidx"})Pageable pageable,
            SearchCondition searchCondition) {
        return companyService.getCompanyList(pageable, searchCondition);
    }
    //작성용
    @PostMapping("/company")
    public CompanyEntity create(@RequestBody CompanyDto companyDto) { return companyService.create(companyDto); }
    //수정용
    @PatchMapping("/company")
    public  List<CompanyEntity> update(@RequestBody List<CompanyDto> companyDtoList) { return  companyService.update(companyDtoList); }
    //삭제용
    @DeleteMapping("/company/{id}")
    public void delete(@PathVariable Long id) { companyService.delete(id); }

}
