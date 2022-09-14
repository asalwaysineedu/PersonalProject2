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
        :to="communityItem.route"
        > {{ communityItem.title }} </v-btn>
    </v-col>
  </v-toolbar>

  <v-row>
    <v-col align="center">
      <h2>공지사항</h2>
      <p>최신 업데이트된 소식을 만나보세요!</p>
    </v-col>
  </v-row>

  <!-- 게시물 목록 컴포넌트 -->
  <notice-list :noticeBoards="noticeBoards"/>
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
                { title: '공지사항', route: '/Notice' },
                { title: '1:1 문의', route: '' },
                { title: '이벤트', route: '' },
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
        ...mapState(['noticeBoards'])
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
    margin-top: 50px;
  }

  p {
    font-size: 14px;
  }
  

</style>