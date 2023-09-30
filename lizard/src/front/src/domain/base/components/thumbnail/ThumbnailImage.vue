<template>
  <div class="user thumbnail">
    <span class="blind">유저 정보</span>
    <img class="user_image" :src="User" width="28" height="28"/>
    <div class="real-image" :style="{ backgroundImage: 'url(' + userImage + ')' }" ></div>
  </div>
</template>

<script>
import User from '@/images/icon_user_my.svg';
export default {
  name: "ThumbnailImage",
  data() {
    return {
      User: User,
    }
  },
  props: {
    userImage: {
      default: null,
      type: String
    },
  }
}
</script>

<style scoped lang="scss">
  @import "./ThumbnailImage.scss";
</style>