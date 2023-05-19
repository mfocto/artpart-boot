package org.ict.artpart.using.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.Pagination;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.using.entity.UsingEntity;
import org.ict.artpart.using.entity.UsingRepository;
import org.ict.artpart.using.entity.UsingRepositoryCustom;
import org.ict.artpart.using.model.dto.UsingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsingService {
    private final UsingRepository usingRepository;
    private final UsingRepositoryCustom usingRepositoryCustom;

    public Header<List<UsingDto>> getUsingList(Pageable pageable) {

    List<UsingDto> list = new ArrayList<UsingDto>();
        Page<UsingEntity> usingEntities = usingRepositoryCustom.findAll(pageable);
        for(UsingEntity  entity : usingEntities){
            UsingDto dto = UsingDto.builder()
                    .detailIdx(entity.getDetailIdx())
                    .memberIdx(entity.getMemberIdx().getMemberIdx())
                    .paymentDate(entity.getPaymentDate())
                    .paymentDedLine(entity.getPaymentDedLine())
                    .paymentMoney(entity.getPaymentMoney())
                    .paymentBank(entity.getPaymentBank())
                    .bankNumber(entity.getBankNumber())
                    .paymentStatus(entity.getPaymentStatus())
                    .build();
            list.add(dto);
        }
        Pagination pagination = new Pagination(
            (int) usingEntities.getTotalElements()
                    , pageable.getPageNumber() + 1
                    , pageable.getPageSize()
                    , 15
        );
        return Header.OK(list, pagination);
    }


}
