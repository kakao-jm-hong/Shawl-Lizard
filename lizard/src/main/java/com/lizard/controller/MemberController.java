package com.lizard.controller;

import com.lizard.model.dto.MemberDto;
import com.lizard.model.entity.Member;
import com.lizard.model.result.BaseResult;
import com.lizard.repository.MemberRepository;
import com.lizard.service.MemberService;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController extends BaseController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    /**
     * login 관련 API 입니다.
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody LoginRequest loginRequest) {
        MemberDto memberDto = loginRequest.toMemberDto();

        String secretKey;
        try {
            secretKey = memberService.loginCheck(memberDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(BaseResult.isFail("로그인에 실패하였습니다."));
        }

        //TODO: cookie 저장.

        return ResponseEntity.ok().body(BaseResult.isSuccess("로그인에 성공하였습니다.").add("shawl_key", secretKey));
    }

    /**
     * Member 생성
     *
     * @param memberRequest
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<BaseResult> createMember(@RequestBody MemberRequest memberRequest) {
        try {
            log.debug("memberResult valid check");
            memberRequest.validCheck();
        } catch (IllegalStateException e) {
            log.info("비밀번호 일치 실패");
            return ResponseEntity.ok().body(BaseResult.isFail(e.getMessage()));
        }

        MemberDto memberDto = memberRequest.toMemberDto();
        Member createMember = memberService.createMember(memberDto);

        if (createMember == null) {
            log.info("Member 생성 실패");
            return ResponseEntity.ok().body(BaseResult.isFail("member 를 생성하는데 실패하였습니다."));
        }

        return ResponseEntity.ok().body((BaseResult.isSuccess("회원가입에 성공하였습니다.")));
    }

    /**
     * nickName 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/nickname/{id}")
    public ResponseEntity<BaseResult> getNickName(@PathVariable("id") Long id) {
        log.info("search nickname id = {}", id);

        Optional<Member> member = memberRepository.findById(id);

        if (member.isPresent()) {
            return ResponseEntity.ok().body(BaseResult.isSuccess("nickname 조회 성공하였습니다."));
        }

        return ResponseEntity.ok().body(BaseResult.isFail("nickname 조회 실패하였습니다."));
    }

    @Getter
    @Setter
    static class MemberRequest {
        @NotNull
        String memberId;
        @NotNull
        String password;
        @NotNull
        String passwordCheck;
        @NotNull
        String nickname;

        /**
         * 패스워드 일치 확인
         */
        //TODO: memberId, nickName 유효성 체크
        void validCheck() {
            if (!this.password.equals(this.passwordCheck)) {
                throw new IllegalStateException("패스워드가 일치하는지 확인해 주세요.");
            }
        }

        MemberDto toMemberDto() {
            return MemberDto.builder()
                    .memberId(memberId)
                    .nickname(nickname)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @Setter
    private class LoginRequest {
        @NotNull
        String memberId;
        @NotNull
        String password;

        MemberDto toMemberDto() {
            return MemberDto.builder()
                    .memberId(memberId)
                    .password(password)
                    .build();
        }
    }
}
