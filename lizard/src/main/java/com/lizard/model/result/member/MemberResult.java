package com.lizard.model.result.member;

import com.lizard.model.result.BaseResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberResult extends BaseResult {
  String nickName;
  String image;
  String token;
}
