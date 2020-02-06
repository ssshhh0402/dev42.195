<template>
    <v-row style="margin:10px" justify="center">
        <v-col cols="2">
            <!-- 여기에 공모전 데이터를 보여주고 -->
        <v-card-title class="headline" style="margin:auto" > {{contents.i_title}} </v-card-title>

            <v-row>
                <!--
                    <v-col cols="12">
                        <v-file-input outlined type="file" id="file" ref="file" accept="image/*" v-model="chosenFile" v-on:change="handleFileUpload"/>
                    </v-col>
                -->
                <v-col cols="12">
                    <v-img :src="contents.img_url"></v-img>
                </v-col>
                <v-col cols="12">
                    인원
                    <v-text-field readonly :value="contents.people_num"></v-text-field>
                </v-col>
                <v-col cols="12">
                    장소
                    <v-text-field readonly :value="contents.location"></v-text-field>
                </v-col>
            </v-row>
        </v-col>
        <v-col cols = "10">    
        <v-card-title class="headline" style="margin:auto" > 참여 PAGE </v-card-title>
            <v-card width="80vw" >
            <v-container>
                <v-card-title class="headline" style="margin:auto" > 신청자 정보 </v-card-title>
                <v-card-text>
                    <v-row>
                        <v-col cols="6">
                            이름
                            <v-text-field  :value="name" readonly required></v-text-field>
                        </v-col>
                        <v-col cols="6">
                            ID
                            <v-text-field :value="email" readonly required></v-text-field>
                        </v-col>
                        <v-col cols="6">
                            소속
                            <v-text-field  label="소속"></v-text-field>
                        </v-col>
                        <v-col cols="6">
                            전화번호
                            <v-text-field :value="phone" readonly  required></v-text-field>
                        </v-col>
                        <v-col cols="12">
                        <v-row justify="center">
                        <span style="margin:auto 0px auto auto">개인정보동의(필수)</span>  
                            <v-checkbox></v-checkbox>
                        <span style="margin:auto auto auto 0px">(더보기)</span>
                        </v-row>
                        
                        </v-col>
                    </v-row>
                </v-card-text>
                </v-container>
                </v-card>
        <v-card width="80vw" >
            <v-container>
                <v-card-title class="headline" style="margin:auto" > 정보 입력 </v-card-title>
                <v-card-text>
                    <v-row>
                        <!-- 신청자 정보 -->

                        <!-- 입력 form -->
                        <v-col cols="6" md="6" sm="12">
                            <v-text-field v-model="idea_title" label="아이디어 명*" required></v-text-field>
                        </v-col>
                        <v-col cols="6" md="6" sm="12">
                            <v-text-field v-model="team_title" label="팀 명*" required></v-text-field>
                        </v-col>
                        <v-col cols="3">
                            <v-text-field v-model="team_chef" label="팀장 명 *" required></v-text-field>
                        </v-col>
                        <v-col cols="6" md="6" sm="6">
                            <v-autocomplete v-model="value" :items="allEmail"  :label="seletedEmail" ></v-autocomplete>
                        </v-col>
                        <v-col cols="3" md="3" sm="3">
                            <v-text-field type="number" v-model="team_many" readonly solo-inverted label=" 명*" required></v-text-field>
                        </v-col>
                        <v-col cols="12">
                            <v-textarea 
                                filled auto-grow rows="4" row-height="30" shaped
                                v-model="info" label="아이디어 설명" required>
                            </v-textarea>
                    </v-col>
                    </v-row>
                </v-card-text>
            </v-container>
        </v-card>
        </v-col>
    </v-row>
</template>
<script>
// import http from '../../http-common';
import git from '../../git-common';
export default {
    data(){
        return{
            value: null,
            contents : null,
            idea_title:"",
            team_title:"",
            team_chef:"",
            team_many:Number,
            info:"",
            name:"",
            phone:"",
            email:"",
            allEmail:null,
            seletedEmail:"",
        }
    },
    methods:{
        getUserInfo(){
            git.defaults.headers.common['x-access-token'] = sessionStorage.getItem('x-access-token');
            git.get('/user')
            .then(response=>{
                console.log(response);
                return this.initProfile(response.data);
            })
            .catch(err=>{
                console.log(err);
            })
        },
        searchID(){
            git.get('/getMemberByID/'+this.value)
            .then(resposne=>{
                console.log(resposne.data);
            })
            .catch(err=>{
                console.log(err);
            })
        },
        initProfile(data){
            console.log(">?>>>>>>>>>");
            console.log(data);
            this.name = data.member.name;
            this.email = data.member.email;
            this.phone = data.member.phone;
        },
        getFindAllEmail(){
            git.get('/findAllEmail')
            .then(response=>{
                console.log(">>ApplyHackatonPage.vue---------------getFindAllEmail()--------------");
                
                if(response.data.state=='succ'){
                    console.log(response.data);
                    console.log(">>>>>>USER LIST>>>>>>");
                    console.log(response.data.data);
                    return this.allEmail = response.data.data;
                }else{
                    console.log('실패');
                    return;
                }
            })
            .catch(err=>{
                console.log(err)
            })
        }
    },
    mounted(){
        this.contents = JSON.parse(sessionStorage.getItem("contents"));
        console.log(this.contents);
        this.getUserInfo();
        this.getFindAllEmail();
    },
    watch:{
        value(){
            console.log(this.value);
            // this.searchID();
            this.seletedEmail+=this.value+", ";
        }
    }

}
</script>