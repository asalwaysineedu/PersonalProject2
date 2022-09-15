<template>
    <div class="nav-list-bar">
        <v-app-bar flat color="white">
        <!-- 로고 -->
        <router-link to="/main">
            <h1><img src="@/assets/healflix_logo.png" style="width:100px" class="mt-3 ml-2"/></h1>
        </router-link>

        <v-spacer></v-spacer>
        <!-- 검색 -->
        <v-text-field
            label="검색"
            hide-details
            append-icon="mdi-magnify"
            v-model="keyword"
            single-line
            filled
            dense
            color="#2a46ff"
            rounded></v-text-field>
        <v-spacer></v-spacer>

        <!-- 커뮤니티 메뉴 리스트 -->
        <v-menu left open-on-hover offset-y>
            <template v-slot:activator="{ on, attrs }">
                <v-btn
                icon
                v-bind="attrs"
                v-on="on"
                color="#2a46ff">
                <v-icon>mdi-cube-outline</v-icon>
              </v-btn>
            </template>

            <v-list>
              <v-list-item
                v-for="(communityItem, c) in communityItems"
                :key="c"
                :to="communityItem.link"
                link
                
              >
                <v-list-item-title>{{ communityItem.title }}</v-list-item-title>
              </v-list-item>
            </v-list>
        </v-menu>
        
        
        <!-- 사용자 서비스 메뉴 리스트 -->
        <v-menu left open-on-hover offset-y>
            <template v-slot:activator="{ on, attrs }">
                <v-btn
                icon
                v-bind="attrs"
                v-on="on"
                color="#2a46ff"
                class="mr-1">
                <v-icon>mdi-alien-outline</v-icon>
              </v-btn>
            </template>

            <!-- 관리자 관점 -->
            <v-list v-if="this.$store.state.userInfo.auth === '관리자'">
              <v-list-item
                v-for="(adminItem, a) in adminItems"
                :key="a"
                :to="adminItem.link"
                link
                @click="userItemMethod(adminItem.action)"
              >
                <v-list-item-title>{{ adminItem.title }}</v-list-item-title>
              </v-list-item>
            </v-list>

            <!-- 개인 관점 -->
            <v-list v-else>
                <v-list-item
                v-for="(userItem, u) in userItems"
                :key="u"
                :to="userItem.link"
                link
                @click="userItemMethod(userItem.action)"
              >
                <v-list-item-title>{{ userItem.title }}</v-list-item-title>
              </v-list-item>
            </v-list> 
            
        </v-menu>
        
        </v-app-bar>
    </div>
</template>

<script>
export default {
    name: 'TheHeader',
    data() {
        return {
            communityItems: [
                { title: '공지사항', link: '/Notice' },
                { title: '1:1 문의', link: '' },
            ],
            userItems: [
                { title: '업로드', link: '' },
                { title: '프로필', link: '/profile' },
                { title: '로그아웃', action: 'logout' },
            ],
            adminItems: [
                { title: '회원관리', link: '' },
                { title: '로그아웃', action: 'logout' },
            ],
            keyword: ''
        };
    },
    created() {
        this.token = localStorage.getItem("token");
    },
    methods: {
        search() {
            console.log(this.keyword)
            this.$router.push({name: 'SearchPage', params: { keyword: this.keyword }})
        },
        userItemMethod(action) {
            if (action === "logout") {
                localStorage.removeItem("userInfo")
                this.$cookies.remove("user")
                this.isLogin = false
                this.$store.state.userInfo = null
                alert('로그아웃 되었습니다.')
                this.$router.push({name: 'LoginPage'})
            }
        }
    }
}
</script>

<style scoped>

    .v-text-field {
        font-size: 0.85rem;
    }
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
    .v-btn::before {
        display: none;
    }

    .v-list-item__title {
    align-self: center;
    font-size: 0.85rem;
    text-align: center;
    color: #333984;
    }

</style>