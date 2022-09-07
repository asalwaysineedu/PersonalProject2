<template>
    <div class="signup-wrap">
        <sign-up-form @submit ="onSubmit"
                      @checkId="checkDoubleId"
        />
    </div>
</template>

<script>
import SignUpForm from '../../components/member/SignUpForm.vue'
import axios from 'axios'
export default {
    name: 'SignUpPage',
    components: { SignUpForm },
    data() {
        return{
            checkId: false,
        }
    },
    methods: {
        onSubmit(payload) {
            const { id, password, nickname, auth } = payload

            let profileImg = 'profile_base_img.jpg';
            axios.post('http://localhost:7777/member/register', { id, password, nickname, auth, profileImg })
            .then(res => {
              alert('등록 성공! - ' + res)
              this.$router.push({
                    name: 'LoginPage'
                })
            })
            .catch(res => {
              alert(res.response.data.message)
            })
        },
        async checkDoubleId(payload) {
            const {id} = payload;
            let response = await axios.get(`http://localhost:7777/member/checkId/${id}`)
            if(response.data === true){
                alert('사용가능한 아이디입니다.')
                this.checkDoubleId = true;
            }else{
                alert('이미 사용중인 아이디입니다.')
                this.checkDoubleId = false;
            }
        }
    }
}

</script>

<style lang="scss" scoped>
    .signup-wrap {
        background-color: #F4F6FF;
        height: 100%;
    }
</style>