<template>
  <div>
    <button @click="()=> this.showSignUp = true">로그인</button>
    <LoginModal v-show="showSignUp" @close="()=>  this.showSignUp = false"></LoginModal>
    <router-view></router-view>
  </div>
</template>

<script>
import LoginModal from "@/domain/base/components/Modal/LoginModal";
export default {
  name: "BaseMain",
  components: {LoginModal},
  data() {
    return {
      showSignUp: false,
    }
  }
}
</script>

<style scoped>

</style>