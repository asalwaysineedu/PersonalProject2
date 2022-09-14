<template>
  <v-container style="margin-top: 30px;">
    <!-- 필독, 일반 구분 | 제목 -->
    <v-col cols="12">
        <v-chip color="primary">{{noticeBoard.noticeNecessary}}</v-chip>
        <h1>{{ noticeBoard.noticeTitle }}</h1>
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

  </v-container>
</template>

<script>
export default {
  name: 'NoticeRead',
  props: {
    noticeBoard: {
      type: Object,
      require: true
    }
  }
}
</script>

<style lang="scss" scoped>
  h1 {
    margin-top: 0.1rem;
  }
</style>