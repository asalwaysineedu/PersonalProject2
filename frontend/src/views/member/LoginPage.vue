<template>
  <div class="login-wrap">
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import LoginForm from '@/components/member/LoginForm.vue'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  name: 'LoginPage',
  components: {
    LoginForm
  },
  data () {
    return {
      isLogin: false
    }
  },
  mounted() {
    this.$store.state.userInfo = this.$cookies.get("user")

    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    } else {
      this.isLogin = false
    }
  },
  methods: {
    onSubmit (payload) {
      if (!this.isLogin) {
        const {id, password} = payload
        axios.post('http://localhost:7777/member/login', {id, password})
            .then(res => {
              if (res.data) {
                alert('로그인 성공!')
                this.$store.state.userInfo = res.data
                this.$cookies.set("user", res.data, 300)
                this.isLogin = true
                this.$router.push({
                    name: 'MainPage'
                })
                localStorage.setItem("loginId", id)
              } else {
                alert('로그인 실패!')
              }
            })
            .catch(res => {
              alert(res.response.data.message)
            })
      } else {
        alert('이미 로그인이 되어 있습니다.')
      }
    },
    logout () {
      this.$cookies.remove("user")
      this.isLogin = false
      this.$store.state.userInfo = null

      alert('로그아웃 성공')
    }
  }
}
</script>

<style lang="scss" scoped>

  .login-wrap {
    background-color: #F4F6FF;
    height: 100%;
  }

</style>