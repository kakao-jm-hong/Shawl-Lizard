import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import routes from "@/routes";

//setup
import "./css/reset.css";
import "./css/global.css";

Vue.config.productionTip = false;

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

const DEFAULT_TITLE = 'DEFAULT';

router.afterEach((to) => {
    Vue.nextTick(() => {
        document.title = to.meta.title || DEFAULT_TITLE;
    })
});

new Vue({
    render: h => h(App),
    router
}).$mount('#app')
