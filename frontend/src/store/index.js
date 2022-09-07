import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const plugins= [createPersistedState({
  paths: []
})]

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  getters: {},
  plugins
})
