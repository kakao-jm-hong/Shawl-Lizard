<template>
  <li class="item">
    <a class="tabName">{{tabName}}</a>
    <span v-if="items.length !=0" class="shape"></span>
    <ul class="tab" v-if="items.length!=0">
      <li class="tab-li" :key="tabName + index" v-for="(item, index) in items">
        <a :href="item.href">{{item.name}}</a>
      </li>
    </ul>
  </li>
</template>

<script>
export default {
  name: "NavItem",
  props: {
    tabName: {
      type: String,
      default: 'tab'
    },
    items: {
      default: [

      ]
    }
  }
}
</script>

<style scoped>
  @import "NavItem.scss";
</style>