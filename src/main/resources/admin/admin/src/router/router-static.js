import Vue from 'vue';

import VueRouter from 'vue-router'
Vue.use(VueRouter);

import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import relevantInformation from '@/views/modules/relevantInformation/list'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import config from '@/views/modules/config/list'
    import applyForManage from '@/views/modules/applyForManage/list'



const routes = [{
    path: '/index',
    name: 'home page',
    component: Index,
    children: [{

      path: '/',
      name: 'home page',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: 'Change password',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: 'payment',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: 'personal information',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
        path: '/relevantInformation',
        name: 'Related information',
        component: relevantInformation
      }
      ,{
	path: '/forum',
        name: 'Forum communication',
        component: forum
      }
      ,{
	path: '/news',
        name: 'Website Announcement',
        component: news
      }
      ,{
	path: '/yonghu',
        name: 'user',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: 'Contact students',
        component: chat
      }
      ,{
	path: '/config',
        name: 'Carousel management',
        component: config
      }
      ,{
        path: '/applyForManage',
        name: 'College application',
        component: applyForManage
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: 'home page',
    redirect: '/index'
  },
  {
    path: '*',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'hash',

  routes
})
const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
