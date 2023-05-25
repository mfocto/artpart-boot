package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.PaymentMemberEntity;
import org.ict.artpartM.account.entity.PaymentMemberRepository;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentMemberService {
    private final PaymentMemberRepository repository;


    public PaymentMemberEntity create(PaymentPublicDto dto) {
        return null;

    }
}
