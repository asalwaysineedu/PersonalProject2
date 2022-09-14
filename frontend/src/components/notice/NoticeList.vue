<template>
  <div>
    <v-container>
      <v-row>

        <!-- 작성 버튼 -->
        <v-col align="right">
          <router-link :to="{name: 'NoticeRegisterPage'}">
            <v-btn
            rounded
            outlined
            color="#2A46FF"
            >
              <v-icon>mdi-pencil-plus</v-icon>
              작성
            </v-btn>
          </router-link>
        </v-col>

        <!-- 검색 -->
        <v-col cols="12">
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="제목을 입력하세요."
          single-line
          outlined
          dense
          rounded
          color="#2a46ff"
          hide-details></v-text-field>
        </v-col>

    <!-- 게시글 목록 테이블 -->
    <v-col cols="12">
      <v-data-table
      :headers="headers"
      :items="noticeBoards"
      :search="search"
      hide-default-footer
      :page.sync="page"
      :items-per-page="itemsPerPage"
      @page-count="pageCount = $event"
      no-data-text="현재 게시물이 없습니다!"
      >

      <!-- 필독 | 일반 구분 -->
      <template v-slot:[`item.noticeNecessary`]="{ item }">
        <v-icon style="color:#2A46FF" v-if="item.noticeNecessary === '필독'">
          mdi-flag-variant
        </v-icon>
      </template>

      <!-- 제목 클릭시 해당 게시글의 읽기 페이지로 이동 -->
      <template v-slot:[`item.noticeTitle`]="{ item }">
        <router-link
          style="color: black"
          :to="{
            name: 'NoticeReadPage',
            params: { noticeNo: item.noticeNo.toString() },
          }"
        >
          {{ item.noticeTitle }}
        </router-link>
      </template>
      </v-data-table>
      <v-divider/>

      <!-- 페이지네이션 -->
      <v-col>
      <v-pagination
      v-model="page"
      :length="pageCount"
      total-visible="5"
      color="#2A46FF"
      class="mt-3"
      circle>
      </v-pagination>
      </v-col>

    </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'NoticeList',
  props: {
    noticeBoards: {
      type: Array
    },
    userInfo: {
      type: Object,
      require: true
    }
  },
  data() {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 10,
      headers: [
        { text: "구분", value: "noticeNecessary", width: "5%" },
        { text: "제목", value: "noticeTitle", width: "20%" },
        { text: "작성자", value: "noticeWriter", width: "5%" },
        { text: "조회수", value: "noticeView", width: "5%" },
        { text: "등록일", value: "regDate", width: "5%" }, 
      ],
    }
  }
}
</script>

<style lang="scss" scoped>

    .v-text-field {
        font-size: 0.85rem;
    }
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
    .v-btn::before {
        display: none;
    }

    v-pagination {
      margin-top: 1rem;
    }
    
    

</style>