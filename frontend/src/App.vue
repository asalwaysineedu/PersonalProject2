<template>
  <v-app>
    <v-main style="padding: 0">
      <div v-if="
      this.$route.name == 'MainPage' ||
      this.$route.name == 'NoticeListPage' ||
      this.$route.name == 'NoticeReadPage'
      ">
        <the-header/>
      </div>
      <router-view/>
      <!--<div v-if="
      this.$route.name == 'MainPage' ||
      this.$route.name == 'NoticeListPage' ||
      this.$route.name == 'NoticeRegisterPage' ||
      this.$route.name == 'NoticeModifyPage'
      ">
        <the-footer/>
      </div>-->
    </v-main>
    
  </v-app>
</template>

<script>
import TheHeader from "@/components/layout/TheHeader.vue"
//import TheFooter from "@/components/layout/TheFooter.vue"

//import router from './router';
export default {
  components: {
    TheHeader,
    //TheFooter
    //TheTagSearch
  },
  name: 'App',
  data() {
    return {
    }
  },
  created () {
  //         sessionStorage
  if (sessionStorage.getItem('store')) {
   this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
  }
  //        store   sessionStorage 
  window.addEventListener('beforeunload', () => {
   sessionStorage.setItem('store', JSON.stringify(this.$store.state))
  })
 }
}
</script>

<style>

a {
  text-decoration: none;
}

</style>
