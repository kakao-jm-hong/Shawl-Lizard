import HomePage from "@/domain/base/page/HomePage";
import SignUpPage from "@/domain/base/page/SignUpPage";
import BaseMain from "@/domain/base/BaseMain";
const routes = [
  {
    path: '/base',
    redirect: '/base/home',
    component: BaseMain,
    children: [
      {
        path: 'home',
        component: HomePage,
        meta: {
          title: '메인'
        }
      },
      {
        path: 'signUp',
        component: SignUpPage,
        meta: {
          title: '회원가입'
        }
      }
    ]
  },

];

export default routes;