<template>
  <v-container>
    <notice-modify :noticeBoard="noticeBoard" @submit="onSubmit"/>
  </v-container>
</template>

<script>
import NoticeModify from '@/components/notice/NoticeModify.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'NoticeModifyPage',
    components: {
        NoticeModify
    },
    props: {
      noticeNo: {
            type: String,
            required: true
        }
    },
    computed: {
      ...mapState(['noticeBoard'])
    },
    methods: {
        ...mapActions(['fetchNoticeBoard']),
        onSubmit (payload) {
            const { noticeTitle, noticeContent, noticeNecessary } = payload

            axios.put(`http://localhost:7777/notice/${this.noticeNo}`,
                { noticeTitle, noticeWriter: this.noticeBoard.noticeWriter, noticeContent, regDate: this.noticeBoard.regDate, noticeNecessary })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'NoticeReadPage',
                            params: { noticeNo: res.data.noticeNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
}
</script>

<style>

</style>