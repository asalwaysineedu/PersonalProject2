<template>
  <v-app-bar clipped-left app flat outlined>
    <router-link to="/main"><h1 style="color:#2A46FF" class="ml-4 mr-4">H</h1></router-link>
    <router-link to="/profile"><h4 style="color:#2A46FF">스튜디오</h4></router-link>
    <v-spacer></v-spacer>
    <v-btn outlined rounded color="#2a46ff" class="mr-5" @click="logout()">로그아웃</v-btn>
  </v-app-bar>
</template>

<script>
export default {
    name: 'ProfileHeader',
    methods: {
        logout() {
          localStorage.removeItem("userInfo")
          this.$cookies.remove("user")
          this.isLogin = false
          this.$store.state.userInfo = null
          alert('로그아웃 되었습니다.')
          this.$router.push({name: 'LoginPage'})
        }
    }
}
</script>

<style scoped>
.theme--light.v-app-bar.v-toolbar.v-sheet {
    background-color: #fff;
}
</style>