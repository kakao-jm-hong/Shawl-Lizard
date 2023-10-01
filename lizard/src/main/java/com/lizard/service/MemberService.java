package com.lizard.service;

import com.lizard.common.JwtUtils;
import com.lizard.model.dto.MemberDto;
import com.lizard.model.entity.Member;
import com.lizard.model.result.member.MemberResult;
import com.lizard.model.result.member.ValidResult;
import com.lizard.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

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
    public MemberResult loginCheck(MemberDto memberDto) throws Exception {
        String memberId = memberDto.getMemberId();
        String password = memberDto.getPassword();
        Optional<Member> member = memberRepository.findByMemberIdAndPassword(memberId, password);
        if(member.isPresent()) {
            return MemberResult.builder()
                .token(JwtUtils.generateToken(memberId))
                .nickName(member.get().getNickname())
                .image("")
                .build();
        }

        throw new Exception("로그인에 실패하였습니다.");
    }

    public ValidResult validUser(String token) {
        boolean isValid = JwtUtils.validateToken(token);
        if(!isValid) {
            ValidResult validResult =ValidResult.builder().build();
            validResult.isFail("유효하지 않은 토큰 입니다.");
            return validResult;
        }
        Claims claimsFromToken = JwtUtils.getClaimsFromToken(token);
        String memberId = claimsFromToken.getSubject();

        boolean isPresent = memberRepository.findByMemberId(memberId).isPresent();

        if(!isPresent) {
            ValidResult validResult = ValidResult.builder().build();
            validResult.isFail("존재하지 않는 계정 입니다.");
            return validResult;
        }

        ValidResult validResult = ValidResult.builder().build();
        validResult.isSuccess("존재하지 않는 계정 입니다.");
        return validResult;
    }
}
