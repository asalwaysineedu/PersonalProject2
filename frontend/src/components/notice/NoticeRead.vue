<template>
  <v-container style="margin-top: 30px;">
    <v-col cols="12">
        <!-- 필독, 일반 구분 | 제목 -->
        <v-chip color="primary">{{noticeBoard.noticeNecessary}}</v-chip>
        <h1>{{ noticeBoard.noticeTitle }}</h1>
        <!-- 관리자 -->
        <div align="right" v-if="this.$store.state.userInfo.auth === '관리자'">
        <router-link :to="{ name: 'NoticeModifyPage' }">
          <v-btn
          color="#2a46ff"
          rounded
          outlined
          class="mr-2"
          >수정</v-btn>
        </router-link>
        <v-btn
          color="#2a46ff"
          rounded
          outlined
          @click="onDelete"
          >삭제</v-btn>
        </div>
    </v-col>

    


    <v-divider></v-divider>

    <!-- 작성자, 조회수, 등록일 -->
    <v-col cols="12" style="font-weight: bold;" align="right">
      <v-chip class="ma-1" color="#F4F6FF">작성자 : {{ noticeBoard.noticeWriter }}</v-chip>
      <v-chip class="ma-1" color="#F4F6FF">조회수 : {{ noticeBoard.noticeView }}</v-chip>
      <v-chip class="ma-1" color="#F4F6FF">등록일 : {{ new Date(noticeBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11) }}</v-chip>
    </v-col>

    <!-- 내용 -->
    <v-col cols="12">
      <v-textarea rows="20"
                  :value="noticeBoard.noticeContent"
                  type="text"
                  auto-grow flat solo
                  readonly></v-textarea>
    </v-col>
    <v-divider></v-divider>

    <!-- 목록 -->
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

  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'NoticeRead',
  props: {
    noticeBoard: {
      type: Object,
      require: true
    },
    userInfo: {
      type: Object,
      require:true
    }
  },
  methods: {
    onDelete() {
      alert('삭제하시겠습니까?')
      const { noticeNo } = this.noticeBoard
      axios.delete(`http://localhost:7777/notice/${noticeNo}`, {noticeNo})
      .then(() => {
        alert('성공적으로 삭제되었습니다.')
        this.$router.push({ name: 'NoticeListPage' })
      })
      .catch(() => {
        alert('삭제 실패했습니다.')
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  h1 {
    margin-top: 0.1rem;
  }
</style>