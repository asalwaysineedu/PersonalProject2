<template>
    <div>
        <profile-header/>
        <profile-side-bar/>
        <profile-content/>
    </div>
</template>

<script>
import ProfileHeader from '@/components/layout/ProfileHeader.vue'
import ProfileSideBar from '@/components/layout/ProfileSideBar.vue'
import ProfileContent from '@/components/layout/ProfileContent.vue'
export default {
    name:'ProfilePage',
    components: { ProfileHeader,ProfileSideBar,ProfileContent }
}
</script>

<style>

</style>