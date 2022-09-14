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

    <!-- 공지사항 게시글 -->
    <notice-read :noticeBoard="noticeBoard"/>

    <!-- 개인:목록 | 관리자:목록,수정,삭제 -->
    <v-col cols="12" align="center">
      <router-link :to="{ name: 'NoticeListPage' }">
        <v-btn
        color="#2a46ff"
        rounded
        outlined
        class="mt-3"
        >목록보기</v-btn>
      </router-link>
    </v-col>
  </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import NoticeRead from '@/components/notice/NoticeRead.vue'

export default {
    name: 'NoticeReadPage',
    props: {
      noticeNo: {
        type: String,
        required: true
      }
    },
    components: {
        NoticeRead
    },
    data() {
      return {
        communityItems: [
                  { title: '공지사항', route: '/Notice' },
                  { title: '1:1 문의', route: '' },
                  { title: '이벤트', route: '' },
              ],
      }
    },
    computed: {
      ...mapState(['noticeBoard'])
    },
    created () {
        this.fetchNoticeBoard(this.noticeNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push({ name: 'NoticeListPage' })
                })
    },
    methods: {
        ...mapActions(['fetchNoticeBoard']),
        onDelete () {
            const { noticeNo } = this.noticeBoard
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/notice/${noticeNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'NoticeListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>

<style>

</style>