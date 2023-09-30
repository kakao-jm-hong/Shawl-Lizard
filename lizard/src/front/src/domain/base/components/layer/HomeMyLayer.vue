<template>
  <div class="wrap">
    <div class="inner">
      <h2 class="title">계정</h2>
      <a href="#" class="user">
        <ThumbnailImage class="thumbnail" :userImage="user.userImage"/>
        <span class="name">{{ user.nickname }}</span>
      </a>
      <div class="interst">
        <a href="#" class="item">0 팔로윙</a>
        <a href="#" class="item">2 팔로워</a>
      </div>
      <div class="list">
        <a href="#" class="join"> 게시글 <span class="number">3</span></a>
        <button type="button" @click="logout" class="logout">로그아웃</button>
      </div>
      <button class="cancel" @click="closeClick"><img :src="Close" width="25" height="25" /></button>
    </div>
  </div>
</template>
<script>
import Close from "@/images/icon_close_search.svg"
import ThumbnailImage from "@/domain/base/components/thumbnail/ThumbnailImage";
export default {
  name: "HomeMyLayer",
  data() {
    return {
      Close : Close
    }
  },
  props: {
    logout: Function,
    className: String
  },
  computed: {
    user() {
      // Vuex 상태로부터 user 데이터를 가져오도록 수정해야 합니다.
      return {
        userImage: "userImageUrl", // 사용자 이미지 URL
        nickname: "HongJenogMin" // 사용자 닉네임
      };
    }
  },
  components: {
    ThumbnailImage
  },
  methods: {
    closeClick() {
      this.$emit('close');
    }
  }
}
</script>

<style scoped lang="scss">
  @import "./HomeMyLayer.scss";
</style>