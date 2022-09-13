<template>
  <div class="notice-register-form-wrap">
    <notice-register @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import NoticeRegister from '@/components/notice/NoticeRegister.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'NoticeRegisterPage',
    components: {
        NoticeRegister
    },
    computed: {
      ...mapState(["user"])
    },
    methods: {
      ...mapActions(["setUser"]),
      onSubmit(payload) {
        const { noticeTitle, noticeContent, noticeNecessary, files, writer } = payload;

        let formData = new FormData();
        let noticeBoard = { noticeTitle, noticeContent, noticeNecessary, files, writer }

        formData.append('hotel',new Blob([JSON.stringify(noticeBoard)],{type: "application/json"}))

        for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }
        axios.post('http://localhost:7777/notice/register', formData, {
                headers: {
                    'Content-Type' : 'multipart/form-data'
                }
            })
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