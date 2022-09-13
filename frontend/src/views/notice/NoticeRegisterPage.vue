<template>
  <div class="notice-register-form-wrap">
    <notice-register @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import NoticeRegister from '@/components/notice/NoticeRegister.vue'

export default {
    name: 'NoticeRegisterPage',
    components: {
        NoticeRegister
    },
    methods: {
      onSubmit(payload) {
        const { noticeTitle, noticeContent, noticeNecessary, noticeWriter } = payload;

        axios.post('http://localhost:7777/notice/register', { noticeTitle, noticeContent, noticeNecessary, noticeWriter })
            .then(() => {
                alert('등록 되었습니다.')
                this.$router.push({
                    name: 'NoticeListPage'
                })
            })
            .catch(() => {
                alert('오류가 발생하였습니다.')
            })
      }
    }
}
</script>

<style scoped>
</style>