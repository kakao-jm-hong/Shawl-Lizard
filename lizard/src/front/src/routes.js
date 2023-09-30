import HomePage from "@/domain/base/page/HomePage";
import IndexPage from "@/IndexPage";
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
];

export default routes;