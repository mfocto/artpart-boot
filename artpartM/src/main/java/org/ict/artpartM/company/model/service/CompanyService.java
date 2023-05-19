package org.ict.artpartM.company.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.company.entity.CompanyEntity;
import org.ict.artpartM.company.entity.CompanyRepository;
import org.ict.artpartM.company.entity.CompanyRepositoryCustom;
import org.ict.artpartM.company.model.dto.CompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyRepositoryCustom companyRepositoryCustom;

    //외부업체 목록 조회
    public Header<List<CompanyDto>> getCompanyList(
            Pageable pageable, SearchCondition searchCondition) {
        List<CompanyDto> dtos = new ArrayList<>();

        Page<CompanyEntity> companyEntities = companyRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(CompanyEntity entity : companyEntities){
            CompanyDto dto = CompanyDto.builder()
                    .companyidx(entity.getCompanyidx())
                    .name(entity.getName())
                    .item(entity.getItem())
                    .phone(entity.getPhone())
                    .address(entity.getAddress())
                    .companydate(entity.getCompanydate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) companyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 15
        );
        return Header.OK(dtos, pagination);
    }

    //외부업체 등록
    public CompanyEntity create(CompanyDto companyDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CompanyEntity entity = CompanyEntity.builder()
                .name(companyDto.getName())
                .item(companyDto.getItem())
                .phone(companyDto.getPhone())
                .address(companyDto.getAddress())
                .companydate(LocalDate.parse(companyDto.getCompanydate(), formatter))
                .build();
        return companyRepository.save(entity);
    }

    public List<CompanyEntity> update(List<CompanyDto> companyDtoList) {
        List<CompanyEntity> updatedEntities = new ArrayList<>();

        for (CompanyDto companyDto : companyDtoList) {
            CompanyEntity entity = companyRepository.findByCompanyidx(companyDto.getCompanyidx());
            entity.setName(companyDto.getName());
            entity.setItem(companyDto.getItem());
            entity.setPhone(companyDto.getPhone());
            entity.setAddress(companyDto.getAddress());
            updatedEntities.add(companyRepository.save(entity));
        }

        return updatedEntities;
    }

    public void delete(Long id) {
        CompanyEntity entity = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 업체를 찾을 수 없습니다."));
        companyRepository.delete(entity);
    }
}
