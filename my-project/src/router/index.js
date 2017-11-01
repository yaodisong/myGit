import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/home'
import Region from  '@/components/home/region/region'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home,
      children: [
        //学校场所信息
        {path: 'Region', name: 'Region', component: Region}
      ]
    }
  ]
})
// Router.beforeEach((to, from, next) => {
//   if(to.path=="/"){
//     let info = Router.app.$local.clearSession("token");
//   }
//   if(to.matched.some((item) => item.meta.login)){
//     let info = Router.app.$local.fetchSession("token");
//     if(info.token){  // 已经登录
//       next()
//     }else{
//       Router.push({
//         path: '/',
//       })
//     }
//   }else{
//     next()
//   }
// })
// export default Router
