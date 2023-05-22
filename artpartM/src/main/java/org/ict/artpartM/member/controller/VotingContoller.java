package org.ict.artpartM.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.VotingEntity;
import org.ict.artpartM.member.model.dto.VotingDto;
import org.ict.artpartM.member.model.service.VotingService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class VotingContoller {
    private final VotingService votingService;

    @GetMapping("/voting/list")
    public Header<List<VotingDto>> votingList(
            @PageableDefault(sort = {"votingidx"}) Pageable pageable,
            SearchCondition searchCondition) {
        return votingService.getVotingList(pageable, searchCondition);
    }

    @GetMapping("/voting/{id}")
    public VotingDto getVoting(@PathVariable Long id) { return votingService.getVoting(id); }

    @PostMapping("/voting")
    public VotingEntity create(@RequestBody VotingDto votingDto) { return votingService.create(votingDto); }

    @PatchMapping("/voting")
    public VotingEntity update(@RequestBody VotingDto votingDto) { return votingService.update(votingDto); }

    @DeleteMapping("/voting/{id}")
    public void delete(@PathVariable Long id) { votingService.delete(id); }

}
