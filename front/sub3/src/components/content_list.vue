<template>
  <v-sheet
    class="mx-auto"
   
    >
    <v-slide-group
      v-model="model"
      show-arrows
    >
    <v-slide-item
      v-for="i in contents"
      :key="i.key"
    >
    <content_item v-bind:img_u="i.img"></content_item>
    </v-slide-item>
    </v-slide-group>
  </v-sheet>
</template>

<script>
import content_item from './content_item'
import http from '../http-common'
export default {
  name: 'content_list',
  components:{
    content_item,
  },
  data(){
      return{
        contents:[
        ],
       model:false 
      }
  },
  methods:{
    init(){
      http.get('./getBoard')
            .then(message =>{
                this.contents=message.data;
            })
    }
  },
  mounted(){
    this.init()
  }
  
};
</script>
