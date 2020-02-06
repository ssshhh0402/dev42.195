<template>
  <v-app >
     <side v-if="!isLogin" @onLogin="onLogin_2" :isLogin="false"/>
     <side v-if="isLogin" @onLogin="onLogin_2" :isLogin="true"/>
      <v-content>
      <ImgBanner/>
      <router-view/>
      <Footer/>
      <RegisterBefore :dialog="onLoginModal" @onLogin="onLogin_2"/>
    </v-content>

  </v-app>
</template>

<script>
import side from './components/side'
import ImgBanner from './components/ImgBanner'
import Footer from './components/seo/Footer'
import RegisterBefore from './components/yoon/RegisterBefore'
export default {
  name: 'App',
  components : {
    side,
    ImgBanner,
    Footer,
    RegisterBefore,
  },
  data(){
    return {
      onLoginModal:false,
      isLogin:false,
    }
  },
  methods:{
    onLogin_2(data){
      console.log("!!!!!!!!!!!!!!!!!!!");
      if(sessionStorage.getItem('x-access-token')===null||sessionStorage.getItem('x-access-token')===undefined||sessionStorage.getItem('x-access-token')===""){
        this.isLogin = false;
        console.log("App.vue>>-----------this.isLogin = null");
      }else{
        this.isLogin = true;
        console.log("App.vue>>-----------this.isLogin Not null----"+this.isLogin);
      }
      this.onLoginModal = data;
    }
  },
  watch:{
        onLoginModal(){
          console.log(this.onLoginModal);
        },
  }
};
</script>
