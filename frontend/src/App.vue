<template>
  <v-app>
    <v-main style="padding: 0">
      <div v-if="
      this.$route.name == 'MainPage' ||
      this.$route.name == 'NoticeListPage'
      
      ">
        <the-header/>
      </div>
      <router-view/>
    </v-main>
    
  </v-app>
</template>

<script>
import TheHeader from "@/components/layout/TheHeader.vue"
//import router from './router';
export default {
  components: {
    TheHeader
  },
  name: 'App',
  data() {
    return {
    }
  },
}
</script>
