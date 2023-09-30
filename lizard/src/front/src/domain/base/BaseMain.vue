<template>
  <div>
    <button @click="()=> this.showSignUp = true">로그인</button>
    <LoginModal v-show="showSignUp" @close="()=>  this.showSignUp = false"></LoginModal>
    <HomeMyLayer v-show="showHomeMyLayer" @close="()=>  this.showHomeMyLayer = false"></HomeMyLayer>
    <router-view></router-view>
  </div>
</template>

<script>
import LoginModal from "@/domain/base/components/modal/LoginModal";
import HomeMyLayer from "@/domain/base/components/layer/HomeMyLayer";
export default {
  name: "BaseMain",
  components: {HomeMyLayer, LoginModal},
  data() {
    return {
      showSignUp: false,
      showHomeMyLayer: false,
    }
  }
}
</script>

<style scoped>

</style>