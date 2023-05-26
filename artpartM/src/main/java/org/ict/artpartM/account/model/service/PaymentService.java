package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.*;
import org.ict.artpartM.account.model.dto.FeeListDto;
import org.ict.artpartM.account.model.dto.PaymentMemberDto;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.entity.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentMemberRepository memberrepository;
    private final MemberRepository memberRepository;
    private final PaymentPublicRepository publicrepository;
    private final PaymentRepositotyCustom custom;

    public PaymentPublicEntity create(PaymentPublicDto dto) {
        return publicrepository.save(PaymentPublicEntity.builder()
                .PPDate(LocalDate.parse((dto.getPPDate()+"-01")))
                .PPFee(dto.getPPFee())
                .build());
    }
    public PaymentMemberEntity create(PaymentMemberDto dto) {

        MemberEntity member = memberRepository.findByMemberdongAndMemberho(dto.getMemberNo().getMemberdong(), dto.getMemberNo().getMemberho());
        if(member == null || member.toString().length() == 0) {
            return null;
        }
        return memberrepository.save(PaymentMemberEntity.builder()
                .memberNo(member)
                .PMDate(LocalDate.parse(dto.getPmDate()+"-01"))
                .PMHeat(dto.getPmHeat())
                .PMOnsu(dto.getPmOnsu())
                .PMGas(dto.getPmGas())
                .PMElec(dto.getPmElec())
                .PMWater(dto.getPmWater())
                .PMSeptic(dto.getPmSeptic())
                .PMWaste(dto.getPmWaste())
                .PMOpercost(dto.getPmOpercost())
                .PMInsure(dto.getPmInsure())
                .build());
    }

    public List<FeeListDto> getList(SearchCondition searchCondition) {
        List<FeeListDto> dtos = new ArrayList<>();
        List<PaymentMemberEntity> memberList = custom.findAllBySearchCondition(searchCondition);
        for(PaymentMemberEntity entity: memberList){
            FeeListDto dto = FeeListDto.builder()
                    .dong(entity.getMemberNo().getMemberdong())
                    .ho(entity.getMemberNo().getMemberho())
                    .gen(publicrepository.findByPPDate(entity.getPMDate()).getPPFee())
                    .heat(entity.getPMHeat())
                    .onsu(entity.getPMOnsu())
                    .gas(entity.getPMGas())
                    .elec(entity.getPMElec())
                    .water(entity.getPMWater())
                    .etc(entity.getPMOpercost()+entity.getPMSeptic()+entity.getPMInsure()+entity.getPMWaste())
                    .date(entity.getPMDate().toString().substring(0,7))
                    .build();

            dto.setSum(dto.getGen()+dto.getHeat()+dto.getOnsu()+dto.getGas()+dto.getElec()+dto.getWater()+dto.getEtc());
            dtos.add(dto);
        }
        return dtos;
    }
}
