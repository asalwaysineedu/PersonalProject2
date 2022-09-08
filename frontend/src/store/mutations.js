import {
    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE_BOARD,

} from './mutation-types'

export default {
    [FETCH_NOTICE_BOARD_LIST] (state, noticeBoards) {
        state.noticeBoards = noticeBoards
    },
    [FETCH_NOTICE_BOARD] (state, noticeBoard) {
        state.noticeBoard = noticeBoard
    }

}