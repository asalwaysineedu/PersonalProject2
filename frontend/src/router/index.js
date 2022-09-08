import Vue from 'vue'
import VueRouter from 'vue-router'

import MainPage from '../views/MainPage.vue'

import SignUpPage from '../views/member/SignUpPage.vue'
import LoginPage from '../views/member/LoginPage.vue'

import NoticeListPage from '../views/notice/NoticeListPage.vue'
import NoticeRegisterPage from '../views/notice/NoticeRegisterPage.vue'
import NoticeReadPage from '../views/notice/NoticeReadPage.vue'
import NoticeModifyPage from '../views/notice/NoticeModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/Notice',
    name: 'NoticeListPage',
    component: NoticeListPage
  },
  {
    path: '/Notice/Register',
    name: 'NoticeRegisterPage',
    component: NoticeRegisterPage
  },
  {
    path: '/Notice/Read/{NoticeNo}',
    name: 'NoticeReadPage',
    component: NoticeReadPage
  },
  {
    path: '/Notice/Modify',
    name: 'NoticeModifyPage',
    component: NoticeModifyPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
