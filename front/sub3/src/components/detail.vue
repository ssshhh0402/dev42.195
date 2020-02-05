<template>
<v-row>
  <v-col cols="12">
  <v-container style="width:75%; margin:auto;border:black solid 1px">
    <v-row no-gutter>
      <v-col
        cols="6" >
        <v-container>
          <v-img
          :src="hackatonData.img_url"
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
                <div class="headline font-weight-bold text-truncate" style="align-items:center;margin:auto;">{{hackatonData.i_title}}</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin; border:black solid 1px;">
                <div style="margin:auto"> 모집 기간 {{hackatonData.s_date}} ~ {{hackatonData.e_date}}</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin;border:black solid 1px;">
                <div style="margin:auto"> 개최자 {{hackatonData.host}}</div>
            </v-row>
            <v-row style="height: 10vw; align-items:center;font-size:3vmin">
                <v-row style='align-items:center'>
                  <v-col
                  cols="6"
                  >
                    <div style="text-align:center;font-size:3vmin;margin:auto" class="text-truncate">{{hackatonData.location}}</div>
                  </v-col>
                  <v-col
                  cols="6">
                    <div style="text-align:center;font-size:2.5vmin;margin:auto">{{hackatonData.people_num}}</div>
                  </v-col>
              </v-row>
            </v-row>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
  <v-container height="10vw" style="width:75%">
    <v-flex>
      <v-layout>
        <a :href="hackatonData.img_url" target="__blank" style="text-decoration:none;margin-left:auto">
          <v-btn
          prima
          color="orange" 
          style=" height: 3rem; width: 15rem; padding: 0; font-size: 2rem; font-weight: bolder">신청하기</v-btn></a>
      </v-layout>
    </v-flex>
  </v-container>
  </v-col>

  <v-row >
    <v-col
    cols="10"
    style="margin:auto">
      <v-tabs
        v-model="tab"
        class="elevation-2"
        dark
        grow
      >
        <v-tabs-slider></v-tabs-slider>
        <v-tab
          v-for="i in tabs"
          :key="i"
          :href="`#tab-${i}`"
        >
          {{tab_item[i-1].title}}
        </v-tab>
  
        <v-tab-item
          v-for="j in tabs"
          :key="j"
          :value="'tab-' + j"
          style="background:black;height:550px"
        >
          <v-card
            flat
            tile
          >
            <div v-if="j === 1">
              <v-row>
                <v-col
                cols="12">
                <hInfo ></hInfo>
                <hoInfo></hoInfo>
                <!-- <div v-if="hackatonData">
                <kmap :address="hackatonData.location"></kmap>
                </div> -->
                </v-col>
              </v-row>
            </div>

            <div v-if="j === 2">
              <hInfo></hInfo>
            </div>
            <div v-if="j ===3">
              <hoInfo></hoInfo>
            </div>
            <div v-if="j === 4">
              <div v-if="hackatonData">
                  <kmap :address="hackatonData.location"></kmap>
              </div>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs>
  </v-col>
  </v-row>

</v-row>
</template>
<script>
import kmap from './k_map'
import hInfo from './hInfo'
import hoInfo from './hoInfo'
export default {
    name:'detail',
    components:{
      kmap,
      hInfo,
      hoInfo
    },
    
    data(){
        return{
          tab:'tab-1',
          tabs:4,
          hackatonData : {
          },
          tab_item:[
            {title : '전체 정보'},
            {title: '대회 정보'},
            {title: '개최자 정보'},
            {title: '위치 정보'}
          ]
            
          
        }
    },
    mounted(){
      this.init()
      
    },
    methods:{
      init(){
        this.hackatonData = JSON.parse(sessionStorage.getItem('contents'))
        console.log(this.hackatonData)
      },
    }
   
}
</script>