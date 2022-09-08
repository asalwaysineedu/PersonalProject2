<template>
<div>
  <v-img src="@/assets/banner.png" style="height:200px"/>
  <router-link :to="{ name: 'NoticeRegisterPage' }" class="btn"><v-btn>작성</v-btn></router-link>
  <notice-list :NoticeBoards="NoticeBoards"/>
</div>
</template>

<script>
import NoticeList from '@/components/notice/NoticeList.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'NoticeListPage',
  props: {
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

<style>

</style>