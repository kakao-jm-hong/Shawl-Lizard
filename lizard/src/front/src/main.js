import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import routes from "@/routes";
import Vuex from 'vuex';
import createPersistedState from "vuex-persistedstate";
import {base} from "@/vuex/store.js";

//setup
import "./css/reset.css";
import "./css/global.css";

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(Vuex);

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

export const store = new Vuex.Store({
    modules: {base},
    plugins: [
        createPersistedState({
            storage: window.sessionStorage,
            // 해당 모듈만 sessionStorage 에 저장합니다.
            paths: [],
        })
    ]
});

new Vue({
    store: store,
    render: h => h(App),
    router
}).$mount('#app')
