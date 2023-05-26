package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.PaymentPublicEntity;
import org.ict.artpartM.account.entity.PaymentPublicRepository;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentPublicService {
    private final PaymentPublicRepository repository;

    public PaymentPublicEntity create(PaymentPublicDto dto) {
        return repository.save(PaymentPublicEntity.builder()
                .PPDate(LocalDate.parse((dto.getPPDate()+"-01")))
                .PPFee(dto.getPPFee())
                .build());
    }
}
