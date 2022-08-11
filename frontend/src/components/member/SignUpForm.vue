<template>
  <div class="signup-wrap">
    <div class="signup-header">
      <h2>환영합니다</h2>
      <p>가입을 통해 더 다양한 서비스를 만나보세요!</p>
    </div>

  <div class="form-wrap">
    <v-form ref="form" v-model="form">
      
      <v-row>
            <v-col>
              <v-btn 
              @click="btnI" 
              depressed
              rounded
              style="width: 100%; height: 5rem; font-size: 1rem"
              :class="{'success': isMember, 'gray': true}"
              >일반</v-btn>
            </v-col>

            <v-col>
              <v-btn 
              @click="btnM" 
              depressed
              rounded
              style="width: 100%; height: 5rem; font-size: 1rem"  
              :class="{'success': isManager, 'gray': true}">관리자</v-btn>
            </v-col>
      </v-row>

      <v-row>
        <v-col sm="9">
          <v-text-field
                label="이메일"
                class="email"
                v-model="email"
                :rules="emailRules"
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
          v-model="PasswordCheck"
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

      <v-row>
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
      </v-row>
     
    </v-form>

    <div class="signup-btn">
    <v-btn 
    style="width:100%"
    depressed
    rounded
    >가입하기</v-btn>

      <router-link :to="{ name: 'LoginPage' }">이미 아이디가 있으신가요?</router-link>
    </div>

    
  </div>
  </div>
</template>

<script>
export default {
    name: 'SignUpForm',
    data() {
      return {
        role: "",
        email: "",
        password: "",
        passwordChecking: "",
        nickname: "",
        mobile: "",
        emailRules: [
        (v) => !!v || "이메일을 입력해 주세요.",
        (v) => /.+@.+\..+/.test(v) || "이메일 형식으로 입력해 주세요",
        (v) => /^[a-zA-Z0-9@.]*$/.test(v) || "다시 한번 확인해 주세요",
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
        ],
        mobileRules: [
        (v) => !!v || "핸드폰 번호를 입력해 주세요.",
        ],
      }
    }
}
</script>

<style lang="scss" scoped>
@import '~@/assets/scss/abstracts/_variables.scss';

  .signup-header {
    h2 {
      text-align: center;
      padding: 120px 0px 0px 0px;
    }
    p {
      text-align: center;
      padding: 5px 0px 20px 0px;
      font-size: 0.8rem;
    }
  }

  .signup-wrap {
    margin: auto;
    width: 25%;
  }

  .signup-btn {

    text-align: center;
      a {
    font-size: 0.8rem;
  }
  }

  .v-text-field ::v-deep input {
    font-size: 0.85rem;
  }

  .v-text-field ::v-deep label {
    font-size: 0.85em;
  }

  

</style>