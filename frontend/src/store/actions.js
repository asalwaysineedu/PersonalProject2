import {
    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE_BOARD,
} from './mutation-types'

import axios from 'axios'
//import router from '@/router'
// npm install axios --save-dev

export default {
    fetchNoticeBoardList ({ commit }) {
        return axios.get('http://localhost:7777/notice/list')
                .then((res) => {
                    commit(FETCH_NOTICE_BOARD_LIST, res.data)
                })
    },
    fetchNoticeBoard ({ commit }, noticeNo ) {
        return axios.get(`http://localhost:7777/notice/${noticeNo}`)
                .then((res) => {
                    commit(FETCH_NOTICE_BOARD, res.data)
                })
    },
}