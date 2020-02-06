<template>
  <v-row>
  <v-container fill style="width:100%;align-items:center; padding:0;">
    <v-row>
      
    <v-col
      cols="12" style="background:#FED64D;padding:0">
      <card_list> </card_list>
    </v-col>
    </v-row>
    <v-row row style="align-contents:center;margin:0;">
      <v-col
      cols="12" style="margin-top:0px">
      <alarm></alarm>
      </v-col>
    </v-row>
    <v-row align-content="center" row fill-height>
      <v-col
      cols="12" style="margin-top:0px">
      </v-col>
      <card_list> </card_list>
      <register-github-member :dialog="ifLogin" @onLogin="onLogin_2"></register-github-member>
    </v-row>
  </v-container>
  </v-row>
  </template>
<script>
import http from '../http-common';
import card_list from '../components/card_list';
import alarm from '../components/alarm';
import RegisterGithubMember from '../components/yoon/RegisterGithubMember';
export default {
  name: 'HelloWorld',
  components : {
    card_list,
    alarm,
    RegisterGithubMember,
  },
  data(){
    return {
      modal : false,
      message : '',
      dialog: false,
      contents:null,
      ifLogin:false,
    }
  },
  methods:{
    checkLogin(){
      let code = location.search.split('code=')[1];
      console.log(code);
      http.post('/github/accessToken',{"code":code})
      .then(response=>{
        console.log(response.data);
        return this.isJWTNull(response.data);
      })
      .catch(err=>{
        console.log(err);
      })
      
    },
    isJWTNull(value){
      sessionStorage.setItem('github-access-token',value.access_token);
      if(value.login_access_token==null||value.login_access_token===null||value.login_access_token=='null'){
        console.log(value);
        this.ifLogin = true;
      }else{
          sessionStorage.setItem('x-access-token',value.login_access_token);
          http.defaults.headers.common['x-access-token'] = value.login_access_token;
          console.log(sessionStorage.getItem('x-access-token'));
          console.log(sessionStorage.getItem('github-access-token'));
      }
    },
    onLogin_2(data){
      console.log("<<<<<<<<<<<<<<");
      this.ifLogin = data;
    }
  },
  mounted(){
    let code = location.search.split('code=')[1];
    if(code!=null&&code!=""&&code!=undefined){
      this.checkLogin();
    }
  },
  watch:{
    ifLogin(){
      console.log(this.ifLogin);
    }
  }
}
</script>

