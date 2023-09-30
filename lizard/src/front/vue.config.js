const path = require('path');

const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: path.resolve(__dirname, '../main/resources/static'),
  devServer: {
    proxy: 'http://localhost:8080'
  },
  css: {
    loaderOptions: {
      sass: {
        additionalData: `@import "@/scss/utils.scss";`,
      },
      scss: {
        additionalData: `@import "@/scss/utils.scss";`,
      },
    },
  },
});



