import Vue from 'vue'
import Router from 'vue-router'
import MainPage from './views/MainPage.vue'
import JoinPage from './views/JoinPage.vue'
import MyPage from './views/MyPage.vue'
import CreatePage from './views/CreatePage.vue'
import DetailPage from './components/detail.vue';
import RegistHackaton from './components/yoon/RegistHacktonPage.vue';
import RegistMemberPage from './components/yoon/RegistMemberPage.vue';
Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes:[
        {
            path: '/',
            name: 'home',
            component: MainPage
        },
        {
            path:'/join',
            name: 'join',
            component: JoinPage
        },
        {
            path:'/my',
            name: 'Info',
            component: MyPage
        },
        {
            path:'/create',
            name:'Create',
            component: CreatePage
        },
        {
            path:'/detail/:id',
            name:'Detail',
            component: DetailPage
        },
        {
            path:'/github*',
            name:'github',
            component: MainPage
        },
        {
            path:'/detailpage/:data',
            name:'detailpage',
            component: DetailPage
        },
        {
            path:'/registhackaton',
            name:'registhackaton',
            component: RegistHackaton
        },
        {
            path:'/registmemberpage',
            name:'registmemberpage',
            component: RegistMemberPage
        }
        //detailpage
    ]
})