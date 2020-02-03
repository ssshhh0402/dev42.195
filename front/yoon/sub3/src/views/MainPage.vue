<template>
  <!-- <div> -->
  <!-- <v-container style="padding:0;margin:0;max-width:100% !important">
    <v-row no-gutters>
      <v-row style="width:100%">
      <v-col 
        outlined         
        cols="12">   -->
        <!-- <v-container>
          <v-layout my-5>  -->               
            <!-- <v-flex>
              <router-link
              to='/join' tag="span" style="cursor:pointer">
              <div style="width=100%;text-align:center;">
                <h2 class="headline mb-3" style="font-weight:bold;font-style:italic">이거 봤어?</h2>
              </div>
              </router-link>
              <content_list></content_list>
            </v-flex>
          </v-layout>
        </v-container>
      </v-col> --> 
       <!-- <v-col
        cols="3" 
        style="margin:auto;border:blue solid 2px ">
        <profile></profile>
       </v-col> -->
      <!-- </v-row>  -->
     <!-- 2번 라인 -->
      <!-- <v-row                                                          
      outlined
      style="align-items:center; overflow:hidden;margin:0;width:100%">
      <div style="width:100%;text-align:center;height:5vw">
        <h2 class="headline mb-3" style="font-weight:bold;font-style:italic">이거 한번 해볼래?</h2>
      </div>
      <v-col      
        cols="4" style="padding:0;">
        <ranking/>
      </v-col>
      <v-col
        cols="8" style="padding:0; max-height:35vw">
        <famous/>
      </v-col>
      </v-row> -->
    
    <!-- <v-row style="align-items:center; width:100%;height:10vw;">
      <div style="margin:auto;">
        <h2> Today </h2>
      </div>
    </v-row>
    <v-row style="align-items:center; width:100%; height:25vw">
      <today/>
    </v-row>
    </v-row>
  </v-container>
</div> -->
<v-row>
  <!-- <v-container style="width:100%; height:15vw; text-align:center;align-items:center;">
    
  </v-container> -->
   <ImgBanner imgSrc="https://www.onlygfx.com/wp-content/uploads/2017/07/yellow-watercolor-brush-stroke-2.png">
      <div style="line-height:1.2em;font-size:10vw;font-weight:bold;font-style:italic" slot="text" class="text-center">DEV 42.195</div>
    </ImgBanner>
<v-container fill style="width:100%;align-items:center; padding:0;">
  <v-row>
    <v-col
    cols="12"
    style="height:5vw; text-align:center">
      <div><h2 class="headline mb-3" style="font-weight:bold;font-style:italic">마! 이거 봤나?</h2></div>
    </v-col>
    <v-col
    cols="12" style="background:#FED64D;padding:0">
    <card_list> </card_list>
    </v-col>
  </v-row>
  <v-row align-content="center" row fill-height>
    <v-col
    cols="12" style="margin-top:0px">
    <alarm></alarm>
    </v-col>
  </v-row>
  <v-row align-content="center" row fill-height>
    <v-col
    cols="12" style="margin-top:0px">
    </v-col>
    <hottest/>
  </v-row>
</v-container>
</v-row>
</template>
<script>
//import content_list from '../components/content_list'
// import profile from '../components/profile'
// import ranking from '../components/ranking'
// import famous from '../components/famous'
// import today from '../components/today'
import card_list from '../components/card_list'
import alarm from '../components/alarm'
import hottest from '../components/hottest'
import ImgBanner from '../components/ImgBanner'
import git from '../git-common';
export default {
  name: 'HelloWorld',
  components : {
    //content_list,
    // profile,
    //ranking,
    //famous,
    //today
    card_list,
    alarm,
    hottest,
    ImgBanner,
    
  },
  data(){
    return {
      modal : false,
      message : '',
      dialog: false,
    }
  },
  methods:{
    isGithubLogin(){ //github login
      let data = location.search.split('code=')[1];
      // let params = new URLSearchParams();
      // params.append("code", data);
      // console.log(data);
      if(data!=null||data!=undefined||data!=""){
      git.post('/github/accessToken', {"code":data})
      .then(response => {
        if(response.data.state=="succ"){
          console.log("<<<<<<<");
          console.log(response.data);
          console.log(">>>>>>>");
          // console.log("성공!");
          // document.cookie = `accessToken=${response.data.name}`;
          // http.defaults.headers.common['x-access-token'] = response.data.name;
        }else{
          console.log("없는 회원입니다. 회원가입을 진행했습니다. ");
        }
      }).catch(err => {
        console.log(err);
        return;
      });
    }
    },
  },
  mounted(){
    this.isGithubLogin()
  }
 
}
</script>
