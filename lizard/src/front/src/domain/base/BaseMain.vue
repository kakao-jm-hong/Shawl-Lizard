<template>
  <div>
    <NavBar></NavBar>
    <LoginModal v-show="showSignUp" @close="()=>  this.showSignUp = false"></LoginModal>
    <HomeMyLayer v-show="showHomeMyLayer" @close="()=>  this.showHomeMyLayer = false"></HomeMyLayer>
    <router-view></router-view>
  </div>
</template>

<script>
import LoginModal from "@/domain/base/components/modal/LoginModal";
import HomeMyLayer from "@/domain/base/components/layer/HomeMyLayer";
import NavBar from "@/domain/base/components/bar/NavBar";
export default {
  name: "BaseMain",
  components: {NavBar, HomeMyLayer, LoginModal},
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