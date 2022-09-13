<template>
<div>
  <!-- 이미지 -->
  <v-img src="@/assets/banner.png" style="height:200px"/>

  <!-- sub menu -->
  <v-toolbar flat dense outlined>
    <v-col align="center">
        <v-btn
        v-for="communityItem, idx in communityItems" :key="idx" 
        rounded 
        small
        depressed
        outlined
        color="#2a46ff"
        class="ml-3"
        > {{ communityItem.title }} </v-btn>
    </v-col>
  </v-toolbar>

  <v-row>
    <v-col cols="12">
      <h2>공지사항</h2>
    </v-col>
  </v-row>
  
  <v-col>
    <router-link :to="{name: 'NoticeRegisterPage'}">
      <v-btn depressed rounded>
        <v-icon>mdi-pencil-plus</v-icon>
        작성</v-btn>
    </router-link>
  </v-col>

  <notice-list :NoticeBoards="NoticeBoards"/>
</div>
</template>

<script>
import NoticeList from '@/components/notice/NoticeList.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'NoticeListPage',
  data() {
    return {
      communityItems: [
                { title: '공지사항', link: '/Notice' },
                { title: '1:1 문의', link: '' },
                { title: 'FAQ', link: '' },
            ],
    }
  },
  props: {
    userInfo: []
  },
  components: {
    NoticeList
  },
  computed: {
        ...mapState(['NoticeBoards'])
  },
  mounted () {
        this.fetchNoticeBoardList()
  },
  methods: {
        ...mapActions(['fetchNoticeBoardList'])
  }
}
</script>

<style lang="scss" scoped>

  h2 {
    text-align: center;
    padding: 2rem;
  }
  

</style>