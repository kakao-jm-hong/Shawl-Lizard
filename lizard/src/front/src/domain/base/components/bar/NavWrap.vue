<template>
  <nav>
    <ul class="gnb">
      <slot></slot>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "NavWrap"
}
</script>

<style scoped lang="scss">
@import "NavWrap.scss";
</style>