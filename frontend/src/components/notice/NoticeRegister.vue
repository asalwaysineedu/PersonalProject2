<template>
    <v-container>
        <h2>공지사항 작성</h2>
        

        <form @submit.prevent="onSubmit">
            <v-row justify="center">
            <v-col cols="12" lg="8">

                <v-select
                single-line
                filled
                dense
                rounded
                v-model="noticeNecessary"
                label="분류" :items="necessaryList"></v-select>

                <v-text-field
                single-line
                filled
                dense
                rounded
                v-model="noticeTitle"
                label="제목을 입력해주세요." type="text"></v-text-field>

                <v-text-field
                single-line
                filled
                dense
                rounded
                v-model="noticeWriter"
                readonly></v-text-field>

                <v-textarea
                single-line
                filled
                dense
                rounded
                v-model="noticeContent" 
                label="내용을 입력해주세요." type="text" height="350px"></v-textarea>

                <v-btn
                style="width:85%"
                depressed
                rounded
                outlined color="#2a46ff"
                type="submit"
                >등록</v-btn>

                <router-link :to="{ name: 'NoticeListPage' }">
                    <v-btn depressed rounded outlined color="#2a46ff" class="ml-5" style="width:12%">
                        <v-icon>mdi-arrow-left</v-icon>
                    </v-btn></router-link>

            </v-col>
            </v-row>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'NoticeRegister',
    props: {
        userInfo: {
            type: Object,
            require: true,
        }
    },
    data() {
        return {
            noticeTitle: '',
            noticeContent: '',
            noticeNecessary: '',
            necessaryList: ['필독','일반'],
            noticeWriter: this.$store.state.userInfo.auth
        }
    },
    create() {
        this.noticeWriter = this.this.$store.state.userInfo.auth
    },
    methods: {
        onSubmit() {
            const { noticeTitle, noticeContent, noticeNecessary, noticeWriter } = this
            this.$emit('submit', { noticeTitle, noticeContent, noticeNecessary, noticeWriter })
        }
    }
}
</script>

<style scoped>
    h2 {
        text-align: center;
        padding: 60px;
        color: #333984;
    }
    .v-text-field {
        font-size: 0.85rem;
    }
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
</style>