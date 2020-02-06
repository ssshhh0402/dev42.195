<template>
<v-row>
<v-col>
  <v-container style="width:75%; margin:auto;border:black solid 1px">
    <v-row no-gutter>
      <v-col
        cols="6" >
        <v-container>
          <v-img
          :src="hackatonData.img"
          style="margin:auto"
          width="100%"
          aspect-ratio="0.8"
          />
        </v-container>
      </v-col>
      <v-col
        cols="6">
        <v-container style="border:black solid 1px">
            <v-row style="height: 10vw; align-items:center; border:black solid 1px;">
                <div class="headline font-weight-bold text-truncate" style="align-items:center;margin:auto;">{{hackatonData.title}}</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin; border:black solid 1px;">
                <div style="margin:auto"> {{hackatonData.price}}원</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin;border:black solid 1px;">
                <div style="margin:auto"> {{hackatonData.host}}</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin">
                  <v-col
                  cols="6"
                  >
                    <div class="text-truncate" style="text-align:center;font-size:3vmin;" > {{hackatonData.location.split(',')[1]}}</div>
                  </v-col>
                  <v-col
                  cols="6">
                    <div style="text-align:center;font-size:2.5vmin;margin:auto">{{hackatonData.people_now}} / {{hackatonData.people_num}}</div>
                  </v-col>
            </v-row>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
  <v-container height="10vw" style="width:75%">
    <v-flex>
      <v-layout>
        <a href="#none" target="__blank" style="text-decoration:none;margin-left:auto">
          <v-btn
          prima
          @click="btnApply()"
          color="orange" 
          style=" height: 3rem; width: 15rem; padding: 0; font-size: 2rem; font-weight: bolder">신청하기</v-btn></a>
      </v-layout>
    </v-flex>
  </v-container>
  </v-col>
  <v-col
    cols="12">
    <div
    style="width:77%;margin:auto">
    <v-tabs
      v-model="tab"
      grow
      background-color="#424242"
    >
      <v-tab
        v-for="tab in tabs"
        :key="tab.key"
        style="color:white;font-size:2rem"
      >
        {{ tab_item[tab-1].title }}
      </v-tab>
    </v-tabs>
    <v-tabs-items
      v-model='tab'>
      <v-tab-item
        v-for="item in tabs"
        :key="item.key"
        style="height:500px">
        <v-card flat>
          <hInfo v-if="item === 1" :content="hackatonData"></hInfo>
          <uInfo v-if="item === 2"></uInfo>
          <k_map v-if="item === 3" :address="hackatonData.location" style="overflow:scroll; overflow-x:hidden "></k_map>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
    </div>
  </v-col>
  <v-col
  cols="12">
    <comment :board_id="hackatonData.board_id"></comment>
  </v-col>
</v-row>
</template>
<script>
import hInfo from './hInfo'
import uInfo from './uInfo'
import k_map from './k_map'
import comment from './comment'
export default {
    name:'detail',
    components:{
      hInfo,
      uInfo,
      k_map,
      comment
    },
    data(){
        return{
          tab:0,
          tabs:3,
          hackatonData : {
          },
          tab_item:[
            {title:'해커톤 정보'},
            {title : '개최자 정보'},
            {title : '위치정보'}
          ]
        }
    },
    mounted(){
      this.hackatonData = JSON.parse(sessionStorage.getItem('contents'))
    },
    methods:{
      btnApply(){
            this.$router.push('applyhackatonpage');
        },
    }

   
}
</script>