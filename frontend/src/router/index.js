import Vue from 'vue'
import VueRouter from 'vue-router'

import MainPage from '../views/MainPage.vue'

import SignUpPage from '../views/member/SignUpPage.vue'
import LoginPage from '../views/member/LoginPage.vue'

import ProfilePage from '../views/member/ProfilePage.vue'

import NoticeListPage from '../views/notice/NoticeListPage.vue'
import NoticeRegisterPage from '../views/notice/NoticeRegisterPage.vue'
import NoticeReadPage from '../views/notice/NoticeReadPage.vue'
import NoticeModifyPage from '../views/notice/NoticeModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/profile',
    name: 'ProfilePage',
    component: ProfilePage
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
    path: '/Notice/Read/:noticeNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/Notice/Modify/:noticeNo',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage
    },
    props: {
      default: true
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
