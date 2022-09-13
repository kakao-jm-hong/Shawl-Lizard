package com.lizard.service;

import com.lizard.model.dto.MemberDto;
import com.lizard.model.entity.Member;
import com.lizard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * Member를 생성합니다.
     * @param memberDto
     * @return
     */
    public Member createMember(MemberDto memberDto) {
        Member member = memberDto.toEntity();

        Member createMember = memberRepository.save(member);
        log.info("member create, member = {}", member);

        return createMember;
    }

    /**
     * Login 권한을 확인합니다.
     * @param memberDto
     * @return
     */
    public String loginCheck(MemberDto memberDto) throws Exception {
        Optional<Member> member = memberRepository.findByMemberIdAndPassword(memberDto.getMemberId(), memberDto.getPassword());
        if(member.isPresent()) {
            return "secret.key";
        }

        throw new Exception("로그인에 실패하였습니다.");
    }
}
