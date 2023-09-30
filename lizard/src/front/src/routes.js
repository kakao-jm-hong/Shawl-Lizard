import HomePage from "@/domain/base/page/HomePage";
import IndexPage from "@/IndexPage";
import SignUpPage from "@/domain/base/page/SignUpPage";
const routes = [
    {
        path: '/',
        component: IndexPage,
        meta: {
            title: 'Index'
        }
    },
    {
        path: '/base',
        component: HomePage,
        meta: {
            title: '기본 뼈대페이지'
        }
    },
    {
        path: '/base/signUp',
        component: SignUpPage,
        meta: {
            title: '뼈대 로그인페이지'
        }
    },
];

export default routes;