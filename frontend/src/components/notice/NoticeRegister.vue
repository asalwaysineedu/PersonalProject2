<template>
    <v-container>
    <h2>공지사항 작성</h2>
        <form @submit.prevent="onSubmit">
            <v-row justify="center">
            <v-col cols="12" lg="8">

                <v-select single-line
                filled
                dense
                rounded
                single_lined
                v-model="noticeNecessary"
                label="분류" :items="necessaryList"></v-select>

                <v-text-field
                single-line
                filled
                dense
                rounded
                v-model="noticeTitle"
                label="제목을 입력해주세요." type="text"></v-text-field>

                <v-textarea
                single-line
                filled
                dense
                rounded
                v-model="noticeContent" 
                label="내용을 입력해주세요." type="text" height="350px"></v-textarea>

                <v-file-input
                single-line
                filled
                dense
                rounded
                counter
                multiple
                show-size
                truncate-length="15"
                label="이미지"
                ></v-file-input>

            <v-img :src="image" alt=""/>

                <v-btn 
                style="width:100%"
                depressed
                rounded
                outlined color="#2a46ff"
                type="submit"
                >등록</v-btn>

            </v-col>
            </v-row>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'NoticeRegister',
    data() {
        return {
            noticeTitle: '',
            noticeContent: '',
            noticeNecessary: '',
            necessaryList: ['필독','일반'],
            files: '',
            image: '',


        }
    }
}
</script>

<style scoped>
    h2 {
        text-align: center;
        padding: 60px;
    }
    .v-text-field {
        font-size: 0.85rem;
    }
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
</style>