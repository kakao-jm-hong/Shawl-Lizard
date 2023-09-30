<template>
  <div>
    <ul>
      <li>
        <span>ID</span>
        <input type="email" v-model="email"/>
      </li>
      <li>
        <span>닉네임</span>
        <input type="text" v-model="nickname"/>
      </li>
      <li>
        <span>비밀번호</span>
        <input type="password" v-model="password"/>
      </li>
      <li>
        <span>비밀번호 확인</span>
        <input type="password" v-model="passwordCheck"/>
      </li>
    </ul>
    <button @click="signUp">가입하기</button>

  </div>
</template>

<script>
import apiHelper from "@/helper/apiHelper";

export default {
  name: "SignUpPage",
  data() {
    return {
      email: '',
      password: '',
      passwordCheck: '',
      nickname: '',
    }
  },
  methods: {
    validate(email, password, passwordCheck, nickname) {
      // 이메일 형식을 확인하는 정규식 패턴
      const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

      // 이메일 형식 확인
      if (!emailPattern.test(email)) {
        alert('올바른 이메일 주소를 입력하세요.');
        return false;
      }

      // 닉네임 확인
      if ("" == nickname) {
        alert('닉네임을 입력하세요');
        return false;
      }

      // 비밀번호와 비밀번호 확인이 일치하는지 확인
      if (password !== passwordCheck) {
        alert('비밀번호가 일치하지 않습니다.');
        return false;
      }

      // 모든 유효성 검사 통과
      return true;
    },
    async signUp() {
      if (!this.validate(this.email, this.password, this.passwordCheck, this.nickname)) {
        return;
      }

      const data = {
        memberId: this.email,
        password: this.password,
        passwordCheck: this.passwordCheck,
        nickname: this.nickname
      }
      const ret = await apiHelper.post("/member/v1/create", data);

      if(ret.status != 0) {
        alert(ret.message);
        return;
      }

      this.$router.push('/base/home');
    }
  }
}
</script>

<style scoped>

</style>