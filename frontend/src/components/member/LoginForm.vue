<template>
  <div class="login-wrap">
    <div class="login-header">
      <h1>로그인</h1>
    </div>

    <v-container justify="center">
        <form class="login-form" @submit.prevent="onSubmit">
          <v-row justify="center">
          <v-col cols="12" lg="8" sm="8">

            <v-text-field
                v-model="id"
                type="text"
                placeholder="ID"
                single-line
                filled
                dense
                height="50px"
                rounded></v-text-field>

            <v-text-field
                v-model="password"
                type="password"
                placeholder="Password"
                single-line
                filled
                dense
                height="50px"
                rounded></v-text-field>

            <v-btn
            class="login-btn"
            style="width:100%"
            depressed
            rounded
            color="#333984"
            type="submit">Login</v-btn>

            <v-col>
              <router-link :to="{ name: '' }">회원가입</router-link>
              <router-link :to="{ name: '' }">아이디 | 비밀번호 찾기</router-link>
            </v-col>
            
          </v-col>
          </v-row>
        </form>
    </v-container>

  </div>
</template>

<script>
export default {
    name: 'LoginForm',
    data() {
        return {
            id: '',
            password: ''
        }
    },
    methods: {
      onSubmit () {
      const { id, password } = this
      this.$emit('submit', { id, password })
      }
    }
}
</script>

<style lang="scss" scoped>

    .login-header {
        h1 {
          text-align: center;
          padding: 200px 0px 30px 0px;
          color: #333984;
        }
    }
    .login-btn {
      color: white;
    }
</style>