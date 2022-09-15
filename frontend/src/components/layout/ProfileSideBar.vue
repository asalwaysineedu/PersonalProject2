<template>
<v-navigation-drawer app clipped>
          <v-list-item class="mt-5 ml-4">
                <!-- 유저 프로필 사진 -->
                <v-list-item-avatar>
                  <img src="@/assets/profile_base_img.jpg">
                </v-list-item-avatar>

                <v-list-item-content>
                    <v-list-item-title style="font-weight:bold;">닉네임</v-list-item-title>
                    <v-list-item-subtitle style="font-size: 0.8rem;">아이디</v-list-item-subtitle>
                </v-list-item-content>
          </v-list-item>
 

        <v-col cols="10">
            <v-btn
            class="ml-5 mb-5"
            style="width:100%"
            depressed
            outlined color="#2a46ff">새 포스트 작성</v-btn>
        </v-col>

      <v-divider></v-divider>


        <v-list
          dense
          rounded
          class="mt-3"
        >
          <v-list-item
            v-for="item in items"
            :key="item.title"
            link
            class="ml-3 mt-2"
            style="width:90%"
          >
            <v-list-item-icon class="ml-1" style="color:gray;">
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>
            <v-list-item-content style="color:gray;">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
</v-navigation-drawer>
</template>

<script>
export default {
    name: 'profileSideBar',
    props: {
        member: {
            type: Object,
            require: true
        }
    },
    data () {
      return {
        items: [
          { title: '대시보드', icon: 'mdi-home-variant-outline' },
          { title: '포스트', icon: 'mdi-post-outline' },
          { title: '시리즈', icon: 'mdi-bookshelf' },
          { title: '통계', icon: 'mdi-chart-areaspline' },
          { title: '멤버십', icon: 'mdi-cash' },
          { title: '구독자', icon: 'mdi-account-group' },
          { title: '설정', icon: 'mdi-cog-outline' },
        ],
      }
    }
}
</script>

<style>

</style>