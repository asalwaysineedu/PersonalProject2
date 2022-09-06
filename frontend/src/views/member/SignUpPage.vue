<template>
    <div class="signup-wrap">
        <sign-up-form @submit ="onSubmit"/>
    </div>
</template>

<script>
import SignUpForm from '../../components/member/SignUpForm.vue'
import axios from 'axios'
export default {
    name: 'SignUpPage',
    components: { SignUpForm },
    methods: {
        onSubmit(payload) {
            const { id, password, nickname, auth } = payload
            axios.post('http://localhost:7777/member/register', { id, password, nickname, auth })
            .then(res => {
              alert('등록 성공! - ' + res)
              this.$router.push({
                    name: 'LoginPage'
                })
            })
            .catch(res => {
              alert(res.response.data.message)
            })
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