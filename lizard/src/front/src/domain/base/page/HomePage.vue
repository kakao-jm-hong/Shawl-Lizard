<template>
  <div>
    <button @click="()=> this.showSignUp = true">로그인</button>



    <LoginModal v-show="showSignUp" @close="()=>  this.showSignUp = false"></LoginModal>
  </div>
</template>

<script>
import LoginModal from "@/domain/base/components/Modal/LoginModal";
export default {
  name: "HomePage",
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