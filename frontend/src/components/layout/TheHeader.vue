<template>
    <div class="nav-list-bar">
        <v-toolbar height="30px" max-width="130px" elevation="0" class="nav-list">
            <!-- 로고 -->
            <v-toolbar-title>
                <router-link to="/">
                        <img src="@/assets/healflix_logo.png" style="width:100px"/>
                </router-link>
            </v-toolbar-title>
        </v-toolbar>

        <!-- 메뉴 -->
        <v-toolbar-items>
            <v-btn
            active-class="main-active"
            class="header_main_item"
            text
            color="#333984"
            v-for="link in menuLinks"
            :key="link.icon"
            :to="link.route">
                {{ link.text }}
            </v-btn>
        </v-toolbar-items>

        <v-spacer></v-spacer>

        <!-- 검색 -->
        <v-toolbar-items>     
            <v-text-field
                label="제목, 사람, 부위"
                hide-details
                append-icon="mdi-magnify"
                v-model="keyword"
                single-line
                filled
                dense
                rounded
                class="mt-3 mr-5"
              ></v-text-field>
            </v-toolbar-items>

            <!-- 알람 -->
            <v-btn icon color="#333984" class="mt-4 mr-3">
                <v-icon>mdi-bell</v-icon>
            </v-btn>

            <!-- 프로필 -->
            <v-btn icon color="#333984" class="mt-4 mr-12" @click="profilePage">
                <v-icon>mdi-account</v-icon>
            </v-btn>
    </div>
</template>

<script>
export default {
    name: 'TheHeader',
    data() {
        return {
            menuLinks: [
                { text: "홈", route: "/" },
                { text: "공지사항", route: "/notice" },
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
        }
    }
}
</script>

<style scoped>

    .nav-list {
        margin: 20px 0px 0px 40px;
    }
    .nav-list-bar {
        display: flex;
    }
    .header_main_item {
        margin-top: 5px;
        font-weight: bold;
    }
    .header_main_item::before {
        display: none;
    }
    .v-text-field {
        font-size: 0.85rem;
    }
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
    .v-btn::before {
        display: none;
    }
    /*
    .nav-list-ul {
        list-style: none;
    }

    .nav-list-ul li {
        font-size: 0.9rem;
        float: left;
        margin: 10px 0px 0px 15px;
    }

    .nav-list-ul li a {
        text-decoration: none;
        color: #333984;
    }
    
    .nav-list-ul li a:hover {
        color: #2A46FF;
    }*/

</style>