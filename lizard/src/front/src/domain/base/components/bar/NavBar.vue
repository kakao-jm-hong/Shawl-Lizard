<template>
<header class="header">
  <div class="wrap">
    <h1 class="logo">
      <img :src="LogoImage" width="48px" height="48px"/>
      <a href="/"><span class="blind">홈으로 이동</span></a>
    </h1>
    <aside class="aside">
      <div class="aside_inner">
        <NavWrap>
          <NavItem :tab-name="'유자식1'" :items="[{name: 'item1',href: '/'}, {name: 'item2',href: '/'}]"/>
          <NavItem :tab-name="'무자식1'"/>
          <NavItem :tab-name="'유자식2'" :items="[{name: 'item1',href: '/'}, {name: 'item2',href: '/'}]"/>
          <NavItem :tab-name="'무자식2'" />
        </NavWrap>
      </div>
    </aside>
  </div>
</header>
</template>

<script>
import NavWrap from "@/domain/base/components/bar/NavWrap";
import NavItem from "@/domain/base/components/bar/NavItem";
import LogoImage from "@/images/roopi.jpeg"
export default {
  name: "NavBar",
  components: {NavItem, NavWrap},
  data() {
    return {
      LogoImage: LogoImage
    }

  }
}
</script>

<style scoped lang="scss">
@import "NavBar.scss";
</style>