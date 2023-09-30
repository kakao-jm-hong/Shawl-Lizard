<template>
  <div class="wrap">
    <div class="inner">
      <div class="video">비디오 OR 그림<span class="blind">비디오 OR 그림</span></div>
      <div class="item">
        <strong class="title">제목</strong>
        <p class="text">설명</p>
        <small class="sub">로그인 하실 경우 이용 약관과 개인정보 정책에 동의합니다</small>
        <a href="" class="facebook">Start With Facebook <img :src="FaceBook" class="icon_facebook" width="25" height="25"/></a>
        <a href="" class="kakao">Start With Kakao<img :src="Kakao" class="icon_kakao" width="35" height="35"/></a>
        <a href="" class="google">Start with Google<img :src="Google" class="icon_google" width="20" height="20"/></a>
        <a href="" class="naver">Start With Naver<img :src="Naver" class="icon_naver" width="30" height="30"/></a>
        <button class="cancel" @click="closeButton" aria-label="취소"><img :src="Close" width="30" height="30"/></button>
      </div>
    </div>
  </div>
</template>

<script>
import FaceBook from "@/images/login_facebook.svg"
import Kakao from "@/images/login_kakao.svg"
import Google from "@/images/login_google.svg"
import Naver from "@/images/login_naver.svg"
import Close from "@/images/icon_close_search.svg"
export default {
  name: "LoginModal",
  data() {
    return {
      FaceBook: FaceBook,
      Kakao: Kakao,
      Google: Google,
      Naver: Naver,
      Close: Close
    }
  },
  methods: {
    closeButton() {
      alert("close");
    }
  }
}
</script>

<style scoped lang="scss">
  @import "./LoginModal.scss";
</style>