<template>
    <div>
    <v-layout wrap>
        <v-flex xs12 sm6 lg3 v-for="i in lists.length" :key="i">
            <join class="ma-3"
            :contents="lists[i-1]"
            ></join>
        </v-flex>
    </v-layout>

    <div class="text-center" style="margin:auto;">
        <v-pagination
            v-model="page"
            class="my-4"
            :length="parseInt(lists.length / 4) + 1"
            ></v-pagination>
    </div>
    </div>
</template>
<script>
import join from './join'
import http from '../http-common'
export default {
    name:'joinlist',
    components:{
        join,
    },
    data(){
        return{
            lists:[
                ],
            
            page : 1,
        }
    },
    mounted(){
        this.setting()
    },
    methods:{
        setting(){
             http.get('./getBoard')
            .then(message =>{
                this.lists=message.data;
            })
    }
}
}
</script>