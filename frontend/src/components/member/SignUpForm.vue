<template>
  <div class="signup-wrap">
    <div class="signup-header">
      <h1>환영합니다</h1>
      <p>가입을 통해 더 다양한 서비스를 만나보세요!</p>
    </div>

  <div class="form-wrap">
    <v-form @submit.prevent="onSubmit">
      
      <!-- 개인 / 사업자 선택 -->
      <v-radio-group v-model="radioGroup" row>
        <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
        <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
      </v-radio-group>
      
        <v-row>
        <v-col sm="9">
          <v-text-field
                label="아이디"
                class="id"
                v-model="id"
                :rules="idRules"
                type="text"
                single-line
                filled
                dense
                rounded
                ></v-text-field>
        </v-col>
        <v-col sm="3">
          <v-btn depressed rounded outlined color="#2a46ff">중복확인</v-btn>
        </v-col>
      </v-row>

        <v-text-field
          label="비밀번호"
          class="password"
          :rules="passwordRules"
          v-model="password"
          type="password"
          single-line
          filled
          dense
          rounded></v-text-field>

        <v-text-field
          label="비밀번호 확인"
          class="password-check"
          :rules="passwordCheckRules"
          type="password"
          single-line
          filled
          dense
          rounded></v-text-field>

        <v-text-field
          label="닉네임"
          class="nickname"
          :rules="nicknameRules"
          v-model="nickname"
          single-line
          filled
          dense
          rounded
        ></v-text-field>

      <!--<v-row>
        <v-col sm="9">
          <v-text-field
            label="핸드폰 번호"
            class="mobile"
            :rules="mobileRules"
            v-model="mobile"
            single-line
            filled
            dense
            rounded></v-text-field>
        </v-col>
        <v-col sm="3">
          <v-btn depressed rounded outlined color="#2a46ff" @click="checkMobile()">본인인증</v-btn>
        </v-col>
      </v-row>-->

      <div class="signup-btn">
        <v-btn 
        style="width:100%"
        depressed
        rounded
        outlined color="#2a46ff"
        type="submit"
        >가입하기</v-btn>
          <router-link :to="{ name: 'LoginPage' }">이미 계정이 있으신가요?</router-link>
      </div>

    </v-form>
    
  </div>
  </div>
</template>

<script>
export default {
    name: 'SignUpForm',
    data() {
      return {
        radioGroup: 1,
        kindsOfMember: [
        '개인',
        '관리자'
        ],
        id: '',
        password: '',
        passwordChecking: '',
        nickname: '',
        idRules: [
        (v) => !!v || "아이디를 입력해 주세요."
        ],
        passwordRules: [
        (v) => !!v || "비밀번호를 입력해 주세요.",
        (v) => /^[a-zA-Z0-9]*$/.test(v) || "영문+숫자로만 입력해 주세요",
        (v) => /(?=.*[0-9])(?=.*[a-zA-ZS])/.test(v) || "영문+숫자를 섞어주세요",
        (v) => !(v && v.length < 8) || "8자리 이상만 가능합니다.",
        (v) => !(v && v.length > 15) || "15자리를 넘길 수 없습니다.",
        ],
        passwordCheckRules: [
        (v) => this.password === v || "비밀번호가 일치하지 않습니다",
        ],
        nicknameRules: [
        (v) => !!v || "닉네임을 입력해 주세요.",
        (v) => !(v && v.length > 9) || "8글자 이하만 가능합니다.",
        ]
      }
    },
    methods: {
      onSubmit() {
        const { id, password, nickname, radioGroup } = this;
        const auth = (radioGroup == '개인' ? '개인' : '관리자')
        this.$emit('submit', { id, password, nickname, auth })
      },
    }
}
</script>

<style lang="scss" scoped>
@import '~@/assets/scss/abstracts/_variables.scss';
@import '~@/assets/scss/member/SignUpForm.scss';
</style>