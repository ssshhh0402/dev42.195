<template>
        <v-card @click="clickCard()">
            <v-img :src="contents.img" height="45vh"></v-img>
            <v-card-title primary-title>
                <!-- <div :id="color" style="background:black;width:30px;height:30px;border-radius:75px"/><div class="headline font-weight-bold text-truncate">{{contents.title}}</div> -->
                <v-row>
                <v-col
                cols="2"
                :id="color" 
                style="background:black;border-radius:75px">
                </v-col>
                <v-col
                cols="10"
                class="headline font-weight-bold text-truncate">
                {{contents.title}}
                </v-col>
                </v-row>
            </v-card-title>
            <v-card-text>
                <p class="grey--text text-center"> 대회 기간: {{contents.start}} ~ {{contents.end}}</p>
                <p class="grey--text text-center"> 모집 기간: {{contents.apply_start}} ~ {{contents.apply_end}}</p>
                <p class="grey--text text-center">{{contents.price}}</p>
            </v-card-text>
          
        </v-card>
</template>
<script>
export default {
    name:'join',
    props:{
        contents:{type:Object}
    },
    data(){
        return{
            color : ''
        }
    },
    methods:{
        clickCard(){
            sessionStorage.setItem("contents", JSON.stringify(this.contents))
            console.log(sessionStorage.getItem('contents'))
            this.$router.push({name:'detailpage'})
        },
        init(){
            var now_date = parseInt(new Date().toString().split('-').join(''));
            var content_start = parseInt(this.contents.apply_date.split('-').join(''));
            var content_end = parseInt(this.contents.end.split('-').join(''));
            var content_a_start = parseInt(this.contents.start.split('-').join(''));
            var content_a_end = parseInt(this.content.end.split('-').join(''))
            if (now_date > content_end){
                this.color="red"
            }else if(content_start <= now_date <= content_end){
                this.color="yellow"
            }else if(content_a_start <= now_date <= content_a_end){
                this.color="green"
            }else{
                this.color="black"
            }
        }
    },
    mounted(){
        this.init()
    }
   
}
</script>
<style>
    .red {
        background:'red';
    }
    .yellow {
        background: 'yellow';
    }
    .green{
        background:'green';
    }
    .black{
        background:'black';
    }
    
</style>