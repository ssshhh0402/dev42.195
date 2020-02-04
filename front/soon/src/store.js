import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex,{persist: true})
export default new Vuex.Store({
    state:{
        accessToken: '',
        user: '',
        contents: {
            'img_url': '',
            'i_title': '',
            's_date': '',
            'e_date' : '',
            'location' : '',
            'host': '',
            'people_num': ''
        },
    },
    mutations:{
        getContents(state,payload){
            this.state.contents = payload
        }
    }
})