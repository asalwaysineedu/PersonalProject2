<template>
<v-container justify="center">
  <div align="center" class="login-wrap">
    <v-col cols="12">
      <h1><img src="@/assets/healflix_logo.png" width="250px" class="mt-3 ml-2"/></h1>
    </v-col>

        <form class="login-form" @submit.prevent="onSubmit">
          <v-row justify="center">
          <v-col cols="8">

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
            outlined
            rounded
            color="#2A46FF"
            type="submit">Login</v-btn>

            <v-divider/>

            <v-col cols="12" class="mt-3">
              <router-link :to="{ name: 'SignUpPage' }" class="mr-5" style="color:#2A46FF;">회원가입</router-link>
              <router-link :to="{ name: '' }" style="color:#2A46FF;">아이디 | 비밀번호 찾기</router-link>
            </v-col>
            
          </v-col>
          </v-row>
        </form>


  </div>
    </v-container>
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

.login-wrap {
  margin-top: 12rem;
  
}

    .login-btn {
      color: white;
    }
</style>