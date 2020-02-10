<template>
    <div>
    <v-layout wrap>
        <v-card  
        flat
        style="width:100%; height:3vw; background:#fafafa">
        <v-select
        :items="items"
        solo
        hide-details
        :label="items[order]"
        v-model="order"
        background-color="white"
        style="margin-left:auto;height:2vw;width:20%;text-align:center;font-size:1.1rem"
        >
        </v-select>
        </v-card>
        <v-flex id="test" xs12 sm6 lg3 v-for="i in sortedlists.slice(8*(page-1),8*(page-1)+8)" :key="i.key">
            <join class="ma-3"
            :contents="i"
            ></join>
        </v-flex>
    </v-layout>

    <div class="text-center" style="margin:auto;">
        <v-pagination
            v-model="page"
            class="my-4"
            :length="page_limit"
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
            page_limit : 0,
            order: '날짜',
            items : ['날짜','이름','참가비용']
        }
    },
    mounted(){
        this.setting()
        this.sorting()
    },
    methods:{
        setting(){  
             http.get('./getBoard')
            .then(message =>{
                this.lists=message.data;
                if (this.lists.length % 8 === 0){
                    this.page_limit = this.lists.length / 8
                }else {
                    this.page_limit = (this.lists.length / 8) + 1
                }
            })
        },
        sorting(order){
            var ab= this.lists.sort(function(a,b){
                if (order === '날짜'){
                    if(a.start > b.start){
                        return 1;
                    }else if(a.start < b.start){
                        return -1;
                    }return 0
                }else if(order === '이름'){
                    var c = a.title.toUpperCase();
                    var d = b.title.toUpperCase();
                    if (c > d){
                        return 1;
                    }else if(c < d){
                        return -1;
                    }return 0
                }else if(order === '참가비용'){
                    if (a.price < b.price){
                        return -1;
                    }else if(a.price > b.price){
                        return 1;
                    }return 0;
                }
            })
            return ab;
        }
    },
    computed:{
        sortedlists(){
            let sorted = this.sorting(this.order);
            return sorted;
        }
    }

    // watch:{
    //     order : function(reorder){
    //         this.reorder(reorder);
            // this.lists = this.lists.sort(function(a,b){
            //     if (reorder === '날짜'){
            //         if(a.start > b.start){
            //             return 1;
            //         } else if(a.start < b.start){
            //             return -1;
            //         }
            //         return 0
            //     } else if(reorder === '이름'){
            //         var c = a.title.toUpperCase();
            //         var d = b.title.toUpperCase();
            //         if (c > d){
            //             return 1
            //         }else if (c < d){
            //             return -1
            //         }
            //         return 0
            //     } else if(reorder === '참가비용'){
            //         if (a.price - b.price < 0){
            //             return -1
            //         }else if(a.price - b.price > 0){
            //             return 1
            //         }
            //         return 0
            //     }
            // })
            // console.log(this.lists)
            // var evt= document.getElementById('test')
            // console.log(evt)
            // evt.$forceUpdate();
        // }
    // }
}
</script>