<template>
    <v-content>
        <v-form>
            <v-col>
                <h2 class="ml-10 mt-10">기본 정보</h2>
            </v-col>
            <v-col>
                <h4 class="ml-10 mt-5">프로필 사진</h4>
            </v-col>
            <v-row>
                <img src="@/assets/profile_base_img.jpg" width="80px" height="80px" class="ml-16 mt-2">
                <v-col cols="7">
                    <v-file-input
                    class="mt-1 ml-1"
                    prepend-icon=""
                    dense
                    single-line
                    outlined
                    multiple
                    hide-details
                    label="파일을 선택해 주세요"
                    @change="handleFileUpload()"
                    ></v-file-input>
                    <p style="font-size:0.8rem; color:gray;" class="mt-2 ml-1">최대 20MB의 이미지 파일</p>
                </v-col>
            </v-row>
            <v-col cols="9">
                <h4 class="ml-10 mt-5">아이디</h4>
                <v-text-field 
                class="ml-10 mt-3"
                single-line 
                outlined
                dense
                hide-details
                ></v-text-field>
            </v-col>
            <v-col cols="9">
                <h4 class="ml-10">비밀번호</h4>
                <v-text-field 
                class="ml-10 mt-3"
                single-line 
                outlined
                dense
                hide-details
                ></v-text-field>
            </v-col>
            <v-col cols="9">
                <h4 class="ml-10">비밀번호 확인</h4>
                <v-text-field 
                class="ml-10 mt-3"
                single-line 
                outlined
                dense
                hide-details
                ></v-text-field>
            </v-col>
            <v-col cols="9">
                <h4 class="ml-10">닉네임</h4>
                <v-text-field 
                class="ml-10 mt-3"
                single-line 
                outlined
                dense
                hide-details
                ></v-text-field>
            </v-col>

            <v-col cols="9">
                <v-btn class="mt-5 ml-10" depressed color="#2A46FF" style="color:white;">변경 내용 저장</v-btn>
                <v-btn class="mt-5 ml-5" depressed color="#2A46FF" style="color:white;">회원 탈퇴</v-btn>
            </v-col>

        </v-form>
    </v-content>
</template>

<script>
export default {
    name: 'profileContent'
}
</script>

<style scoped>
.v-content {
    background-color: #f8f8f8;
    height: 100vh;
}
</style>