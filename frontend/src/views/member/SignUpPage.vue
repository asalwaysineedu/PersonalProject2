<template>
<div class="signup-wrap">
    <sign-up-form/>
</div>
</template>

<script>
import SignUpForm from '../../components/member/SignUpForm.vue'
export default {
    name: 'SignUpPage',
    components: {
        SignUpForm
    }
}
</script>

<style lang="scss" scoped>
    .signup-wrap {
        background-color: #F4F6FF;
        height: 100%;
    }
</style>