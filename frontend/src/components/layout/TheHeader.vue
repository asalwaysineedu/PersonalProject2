<template>
    <div class="nav-list-bar">
        <v-app-bar flat color="white">
        <!-- 로고 -->
        <router-link to="/">
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

        <!-- 알람 -->
        <v-btn icon color="#2a46ff">
            <v-icon>mdi-chat</v-icon>
        </v-btn>
        
        <!-- 프로필 -->
        <v-btn icon color="#2a46ff" @click="logout" class="mr-1">
            <v-icon>mdi-alien-outline</v-icon>
        </v-btn>
        </v-app-bar>
    </div>
</template>

<script>
export default {
    name: 'TheHeader',
    data() {
        return {
            menuLinks: [
                { text: "홈", route: "/MainPage" },
                { text: "공지사항", route: "/Notice" },
                { text: "NEW! 요즘 대세 운동", route: "/popular" },
                { text: "내가 찜한 영상", route: "my-list" },
            ],
            token: "",
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
        logout() {
            localStorage.removeItem("userInfo")
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.userInfo = null
            alert('로그아웃 되었습니다.')
            this.$router.push({name: 'LoginPage'})
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

</style>